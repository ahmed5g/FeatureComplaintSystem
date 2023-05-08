package tn.pidev.FeatureComplaintSystem.Controllers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pidev.FeatureComplaintSystem.Domain.Complaint;
import tn.pidev.FeatureComplaintSystem.Domain.ComplaintsStatus;
import tn.pidev.FeatureComplaintSystem.Domain.Shipping;
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

    //update only allowded for description
    //customer : Name, Email, Address
    @PutMapping("/update/{complaintId}")
    public Complaint updateComplaint(@PathVariable Long complaintId,@RequestBody Complaint c) {
        Complaint complaint = ComplaintService.updateComplaint(complaintId,c);
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

    // Moderator updates the status of a complaint
    @PutMapping("/{complaintId}/approvalset")
    public ResponseEntity<Complaint> updateComplaintStatus(@PathVariable Long complaintId, @RequestParam String status) {
        Complaint updatedComplaint = ComplaintService.updateComplaintStatus(complaintId, status);
        return new ResponseEntity<>(updatedComplaint, HttpStatus.OK);
    }



    // Moderator updates shipping information for an approved complaint
    //Set the Shippment for approved Complaints
    @PutMapping("/{complaintId}/shipping")
    public void setShippingForComplaint(@PathVariable Long complaintId , @RequestBody Shipping shippment) {
        ComplaintService.updateShippingInfoForComplaint(complaintId, shippment);
    }


    @PutMapping("/{id}/update-shipping-location")
    public void updateShippingLocationGoogleMaps(@PathVariable Long id, @RequestBody String location,
                                       @RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude) {
        ComplaintService.updateShippingLocationGoogleMaps(id, location, latitude, longitude);
    }






}
