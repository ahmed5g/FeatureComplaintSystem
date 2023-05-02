package tn.pidev.FeatureComplaintSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pidev.FeatureComplaintSystem.Domain.Shipping;

@Repository
public interface ShippingRepo extends JpaRepository<Shipping, Long> {


}
