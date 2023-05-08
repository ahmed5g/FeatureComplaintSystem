package tn.pidev.FeatureComplaintSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pidev.FeatureComplaintSystem.Domain.Complaint;
import tn.pidev.FeatureComplaintSystem.Domain.Shipping;
import tn.pidev.FeatureComplaintSystem.Service.Interfaces.IComplaintService;
import tn.pidev.FeatureComplaintSystem.Service.Interfaces.IShippingService;

import java.util.List;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {


    @Autowired
    IShippingService ShippingService;

    @PutMapping("/complaint/{complaintId}")
    public ResponseEntity<Shipping> addShippingToComplaint(@PathVariable Long complaintId, @RequestBody Shipping shipping) {
        Shipping createdShipping = ShippingService.addShippingToComplaint(complaintId, shipping);
        return new ResponseEntity<>(createdShipping, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public List<Shipping> getShippings() {
        List<Shipping> listShipping = ShippingService.retriveAllShippings();
        return listShipping;
    }

    @GetMapping("/{id}")
    public Shipping getShippingByID(@PathVariable("id") Long ShippingID ) {
        Shipping Shipping = ShippingService.retriveShipping(ShippingID);
        return Shipping;
    }

    @DeleteMapping("/{id}/delete")
    public void removeShipping(@PathVariable("id") Long ShippingID) {
        ShippingService.deleteShipping(ShippingID);
    }




}
