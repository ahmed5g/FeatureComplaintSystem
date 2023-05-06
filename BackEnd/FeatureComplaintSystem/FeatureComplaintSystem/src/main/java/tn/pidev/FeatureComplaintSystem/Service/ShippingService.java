package tn.pidev.FeatureComplaintSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pidev.FeatureComplaintSystem.Domain.Shipping;
import tn.pidev.FeatureComplaintSystem.Repo.ShippingRepo;
import tn.pidev.FeatureComplaintSystem.Service.Interfaces.IShippingService;

import java.util.List;

@Service
public class ShippingService implements IShippingService {

    @Autowired
    ShippingRepo ShippingRepo;
    @Override
    public Shipping addShipping(Shipping c) {
        return ShippingRepo.save(c);
    }

    @Override
    public Shipping updateShipping(Shipping c) {
        return ShippingRepo.save(c);
    }

    @Override
    public List<Shipping> retriveAllShippings() {
        return ShippingRepo.findAll();
    }

    @Override
    public Shipping retriveShipping(Long shippingID) {
        return ShippingRepo.findById(shippingID).get();
    }

    @Override
    public void deleteShipping(Long shippingID) {
        ShippingRepo.deleteById(shippingID);

    }
}
