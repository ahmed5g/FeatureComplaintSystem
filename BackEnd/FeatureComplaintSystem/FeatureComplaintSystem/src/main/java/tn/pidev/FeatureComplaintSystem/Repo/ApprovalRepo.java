package tn.pidev.FeatureComplaintSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pidev.FeatureComplaintSystem.Domain.Approval;

public interface ApprovalRepo extends JpaRepository<Approval, Long> {
}
