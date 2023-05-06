package tn.pidev.FeatureComplaintSystem.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pidev.FeatureComplaintSystem.Domain.Approval;
import tn.pidev.FeatureComplaintSystem.Domain.Complaint;
import tn.pidev.FeatureComplaintSystem.Domain.ComplaintsStatus;
import tn.pidev.FeatureComplaintSystem.Domain.Shipping;
import tn.pidev.FeatureComplaintSystem.Repo.ComplaintRepo;
import tn.pidev.FeatureComplaintSystem.Service.Interfaces.IComplaintApprovalService;
import tn.pidev.FeatureComplaintSystem.Service.Interfaces.IComplaintService;

import java.util.List;

@RestController
@RequestMapping("/api/adminApproval")
public class ApprovalController {



    @Autowired
    IComplaintApprovalService ComplaintApprovalService;
    @Autowired
    IComplaintService complaintService;

    @Autowired
    ComplaintRepo complaintRepo;


    @PostMapping("/add")
        public Approval addApproval(@RequestBody Approval c) {
        Approval Approval = ComplaintApprovalService.addApproval(c);
        return Approval;
    }
    @PutMapping("/update")
    public Approval updateApproval(@RequestBody Approval c) {
        Approval Approval = ComplaintApprovalService.updateApproval(c);
        return Approval;
    }

    @DeleteMapping("/{id}/delete")
    public void removeApproval(@PathVariable("id") Long ApprovalID) {
        ComplaintApprovalService.deleteApproval(ApprovalID);
    }
    @GetMapping("/")
    public List<Approval> getApprovals() {
        List<Approval> listApprovals = ComplaintApprovalService.retriveALLApprovals();
        return listApprovals;
    }

    @GetMapping("/{id}")
    public Approval getComplaintByID(@PathVariable("id") Long ApprovalID ) {
        Approval Approval = ComplaintApprovalService.retriveApproval(ApprovalID);
        return Approval;
    }



    @GetMapping("/Moderators/{name}")
    public Approval getApprovalByModerator(@PathVariable("name") String name ) {
        Approval Approval = ComplaintApprovalService.ApprovalByModeratorName(name);
        return Approval;
    }

    @PutMapping("/complaint/{complaintId}/status")
    public void updateComplaintStatusByApproval(@PathVariable Long complaintId, @RequestParam ComplaintsStatus status) {
        ComplaintApprovalService.updateComplaintStatusByApproval(complaintId, status);
    }

    @PutMapping("/complaint/{complaintId}/shippment")
    public void setComplaintShippingByApproval(@PathVariable Long complaintId , @RequestBody Shipping shippment) {
        ComplaintApprovalService.updateComplaintsShippmentForApprovedComplaints(complaintId, shippment);
    }


}
