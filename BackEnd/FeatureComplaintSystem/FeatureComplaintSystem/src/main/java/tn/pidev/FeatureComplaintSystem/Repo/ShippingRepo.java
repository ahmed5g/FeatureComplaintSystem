package tn.pidev.FeatureComplaintSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pidev.FeatureComplaintSystem.Domain.Shipping;

public interface ShippingRepo extends JpaRepository<Shipping, Long> {


}
