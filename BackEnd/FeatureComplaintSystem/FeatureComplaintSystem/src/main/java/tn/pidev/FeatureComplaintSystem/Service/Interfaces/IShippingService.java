package tn.pidev.FeatureComplaintSystem.Service.Interfaces;

import tn.pidev.FeatureComplaintSystem.Domain.Shipping;

import java.util.List;

public interface IShippingService {
    Shipping addShipping(Shipping c);

    Shipping updateShipping(Shipping c);

    List<Shipping> retriveAllShippings();

    Shipping retriveShipping(Long shippingID);

    void deleteShipping(Long shippingID);
}
