package tn.pidev.FeatureComplaintSystem.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pidev.FeatureComplaintSystem.Domain.Complaint;
import tn.pidev.FeatureComplaintSystem.Domain.ComplaintsStatus;
import tn.pidev.FeatureComplaintSystem.Domain.Shipping;
import tn.pidev.FeatureComplaintSystem.Repo.ComplaintRepo;
import tn.pidev.FeatureComplaintSystem.Repo.ShippingRepo;
import tn.pidev.FeatureComplaintSystem.Service.Interfaces.IComplaintService;

import java.util.List;
import java.util.Set;

@Service
public class ComplaintService implements IComplaintService {


    @Autowired
    ComplaintRepo complaintRepo;
    @Autowired
    ShippingRepo shippingRepo;

    @Override
    public Complaint addCompaint(Complaint c) {
        // Set default status to "pending"
        c.setComplaintStatus(ComplaintsStatus.PENDING);
        return complaintRepo.save(c);

    }

    @Override
    public Complaint updateComplaint(Long complaintId, Complaint c) {

        // Get the complaint to be updated from the database
        Complaint existingComplaint = complaintRepo.findById(complaintId)
                .orElseThrow(() -> new EntityNotFoundException("Complaint not found with id: " + complaintId));
        // Update the complaint properties
        existingComplaint.setDescription(c.getDescription());
        existingComplaint.setCustomerName(c.getCustomerName());
        existingComplaint.setCustomerAdress(c.getCustomerAdress());
        existingComplaint.setCustomerEmail(c.getCustomerEmail());
        // Save the updated complaint to the database
        return complaintRepo.save(existingComplaint);
    }

    @Override
    public List<Complaint> retriveAllCompaints() {
        return complaintRepo.findAll();
    }

    @Override
    public Complaint retriveCompaint(Long compaintID) {
        return complaintRepo.findById(compaintID).get();
    }

    @Override
    public void deleteComplaint(Long compaintID) {
        complaintRepo.deleteById(compaintID);
    }

    @Override
    public Complaint updateComplaintStatus(Long complaintId, String status) {
        // Get the complaint to be updated from the database
        Complaint existingComplaint = complaintRepo.findById(complaintId)
                .orElseThrow(() -> new EntityNotFoundException("Complaint not found with id: " + complaintId));

        // Update the complaint status based on the given value
        switch (status.toLowerCase()) {
            case "pending":
                existingComplaint.setComplaintStatus(ComplaintsStatus.PENDING);
                break;
            case "approved":
                existingComplaint.setComplaintStatus(ComplaintsStatus.APPROVED);
                break;
            case "declined":
                existingComplaint.setComplaintStatus(ComplaintsStatus.REJECTED);
                break;
            default:
                throw new IllegalArgumentException("Invalid status value: " + status);
        }

        // Save the updated complaint to the database
        return complaintRepo.save(existingComplaint);
    }

    @Override
    public void updateShippingInfoForComplaint(Long complaintId, Shipping shippingInfo) {
        List<Complaint> approvedComplaints = complaintRepo.findByIdAndComplaintStatus(complaintId, ComplaintsStatus.APPROVED);
        for (Complaint complaint : approvedComplaints) {
            Set<Shipping> shippings = complaint.getShippings();
            shippings.add(shippingInfo);
            complaint.setShippings(shippings);
            complaintRepo.save(complaint);
        }

    }

    @Override
    public void updateShippingLocationGoogleMaps(Long id, String location, Double latitude, Double longitude) {

        Complaint complaint = complaintRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Complaint not found with id: " + id));

        if (complaint.getShippings().isEmpty()) {
            throw new IllegalStateException("No shippings found for complaint with id: " + id);
        }

        // Update the last shipping's recipient address and coordinates
        Shipping lastShipping = complaint.getShippings().iterator().next();
        lastShipping.setRecipient_address(location);
        lastShipping.setRecipient_latitude(latitude);
        lastShipping.setRecipient_longitude(longitude);

        // Save the updated shipping to the database
        shippingRepo.save(lastShipping);

    }
}






