package tn.pidev.FeatureComplaintSystem.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pidev.FeatureComplaintSystem.Domain.Complaint;
import tn.pidev.FeatureComplaintSystem.Domain.Shipping;
import tn.pidev.FeatureComplaintSystem.Repo.ComplaintRepo;
import tn.pidev.FeatureComplaintSystem.Repo.ShippingRepo;
import tn.pidev.FeatureComplaintSystem.Service.Interfaces.IShippingService;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingService implements IShippingService {

    @Autowired
    ShippingRepo ShippingRepo;
    @Autowired
    ComplaintRepo ComplaintRepo;

    @Override
    public List<Shipping> retriveAllShippings() {
        return ShippingRepo.findAll();
    }

    @Override
    public Shipping retriveShipping(Long shippingID) {
        Optional<Shipping> shipping = ShippingRepo.findById(shippingID);
        if (shipping.isPresent()) {
            return shipping.get();
        } else {
            // handle error if shipping object with given ID is not found
            throw new RuntimeException("Shipping not found with ID: " + shippingID);
        }
    }

    @Override
    public void deleteShipping(Long shippingID) {
        ShippingRepo.deleteById(shippingID);

    }

    @Override
    public Shipping addShippingToComplaint(Long complaintId, Shipping shipping) {
        Complaint complaint = ComplaintRepo.findById(complaintId)
                .orElseThrow(() -> new EntityNotFoundException("Complaint not found with id: " + complaintId));

        shipping.setComplaint(complaint);
        return ShippingRepo.save(shipping);
    }
}
