package tn.pidev.FeatureComplaintSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pidev.FeatureComplaintSystem.Domain.Complaint;
import tn.pidev.FeatureComplaintSystem.Repo.ComplaintRepo;
import tn.pidev.FeatureComplaintSystem.Service.Interfaces.IComplaintService;

import java.util.List;

@Service
public class ComplaintService implements IComplaintService {


    @Autowired
    ComplaintRepo complaintRepo;
    @Override
    public Complaint addCompaint(Complaint c) {
    return complaintRepo.save(c);
    }

    @Override
    public Complaint updateComplaint(Complaint c) {
        return complaintRepo.save(c);
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


    }



