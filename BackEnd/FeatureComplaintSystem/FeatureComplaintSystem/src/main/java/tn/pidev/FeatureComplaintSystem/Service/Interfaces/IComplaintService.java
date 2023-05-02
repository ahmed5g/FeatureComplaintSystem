package tn.pidev.FeatureComplaintSystem.Service.Interfaces;

import tn.pidev.FeatureComplaintSystem.Domain.Complaint;

import java.util.List;

public interface IComplaintService {
    Complaint addCompaint(Complaint c);

    Complaint updateComplaint(Complaint c);

    List<Complaint> retriveAllCompaints();

    Complaint retriveCompaint(Long compaintID);

    void deleteComplaint(Long compaintID);

}
