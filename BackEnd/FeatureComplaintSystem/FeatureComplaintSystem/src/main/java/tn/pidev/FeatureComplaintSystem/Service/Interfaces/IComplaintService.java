package tn.pidev.FeatureComplaintSystem.Service.Interfaces;

import tn.pidev.FeatureComplaintSystem.Domain.Complaint;
import tn.pidev.FeatureComplaintSystem.Domain.ComplaintsStatus;
import tn.pidev.FeatureComplaintSystem.Domain.Shipping;

import java.util.List;

public interface IComplaintService {
    Complaint addCompaint(Complaint c);

    Complaint updateComplaint(Long complaintId, Complaint c);

    List<Complaint> retriveAllCompaints();

    Complaint retriveCompaint(Long compaintID);

    void deleteComplaint(Long compaintID);

    Complaint updateComplaintStatus(Long complaintId, String status);

    void updateShippingInfoForComplaint(Long complaintId, Shipping shippingInfo);

}
