package tn.pidev.FeatureComplaintSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pidev.FeatureComplaintSystem.Domain.Complaint;
import tn.pidev.FeatureComplaintSystem.Domain.Shipping;

public interface ComplaintRepo extends JpaRepository<Complaint, Long> {
}
