package tn.pidev.FeatureComplaintSystem.Service.Interfaces;

import tn.pidev.FeatureComplaintSystem.Domain.Shipping;

import java.util.List;

public interface IShippingService {

    List<Shipping> retriveAllShippings();

    Shipping retriveShipping(Long shippingID);

    void deleteShipping(Long shippingID);

    Shipping addShippingToComplaint(Long complaintId, Shipping shipping);
}
