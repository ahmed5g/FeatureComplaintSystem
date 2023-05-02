package tn.pidev.FeatureComplaintSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pidev.FeatureComplaintSystem.Domain.Approval;

@Repository
public interface ApprovalRepo extends JpaRepository<Approval, Long> {
    Approval findByApprovedBy(String name);
}
