package tn.pidev.FeatureComplaintSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pidev.FeatureComplaintSystem.Domain.Complaint;
import tn.pidev.FeatureComplaintSystem.Domain.ComplaintsStatus;
import tn.pidev.FeatureComplaintSystem.Service.Interfaces.IComplaintService;

import java.util.List;

@RestController
@RequestMapping("/api/complaint")

public class ComplaintController {



        @Autowired
        IComplaintService ComplaintService;

    @PostMapping("/add")
    public Complaint addComplaint(@RequestBody Complaint c) {
        Complaint complaint = ComplaintService.addCompaint(c);
        return complaint;
    }
    @PutMapping("/update")
    public Complaint updateComplaint(@RequestBody Complaint c) {
        Complaint complaint = ComplaintService.updateComplaint(c);
        return complaint;
    }

    @GetMapping("/")
    public List<Complaint> getComplaints() {
        List<Complaint> listCompaints = ComplaintService.retriveAllCompaints();
        return listCompaints;
    }

    @GetMapping("/{id}")
    public Complaint getComplaintByID(@PathVariable("id") Long CompaintID ) {
        Complaint complaint = ComplaintService.retriveCompaint(CompaintID);
        return complaint;
    }

    @DeleteMapping("/{id}/delete")
    public void removeComplaint(@PathVariable("id") Long CompaintID) {
        ComplaintService.deleteComplaint(CompaintID);
    }



}
