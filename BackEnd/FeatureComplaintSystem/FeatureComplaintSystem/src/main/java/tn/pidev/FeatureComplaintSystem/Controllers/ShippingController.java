package tn.pidev.FeatureComplaintSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pidev.FeatureComplaintSystem.Domain.Complaint;
import tn.pidev.FeatureComplaintSystem.Domain.Shipping;
import tn.pidev.FeatureComplaintSystem.Service.Interfaces.IComplaintService;
import tn.pidev.FeatureComplaintSystem.Service.Interfaces.IShippingService;

import java.util.List;

@RestController
@RequestMapping("/Shipping")
public class ShippingController {


    @Autowired
    IShippingService ShippingService;

    @PostMapping("/add")
    public Shipping addComplaint(@RequestBody Shipping c) {
        Shipping shipping = ShippingService.addShipping(c);
        return shipping;
    }
    @PutMapping("/update")
    public Shipping updateComplaint(@RequestBody Shipping c) {
        Shipping shipping = ShippingService.updateShipping(c);
        return shipping;
    }

    @GetMapping("/")
    public List<Shipping> getComplaints() {
        List<Shipping> listShipping = ShippingService.retriveAllShippings();
        return listShipping;
    }

    @GetMapping("/{id}")
    public Shipping getComplaintByID(@PathVariable("id") Long ShippingID ) {
        Shipping Shipping = ShippingService.retriveShipping(ShippingID);
        return Shipping;
    }

    @DeleteMapping("/{id}/delete")
    public void removeComplaint(@PathVariable("id") Long ShippingID) {
        ShippingService.deleteShipping(ShippingID);
    }


}
