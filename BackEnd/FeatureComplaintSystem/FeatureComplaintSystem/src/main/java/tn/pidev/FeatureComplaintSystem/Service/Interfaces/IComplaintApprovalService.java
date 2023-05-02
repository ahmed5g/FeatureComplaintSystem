package tn.pidev.FeatureComplaintSystem.Service.Interfaces;

import jakarta.transaction.Transactional;
import tn.pidev.FeatureComplaintSystem.Domain.Approval;
import tn.pidev.FeatureComplaintSystem.Domain.ComplaintsStatus;
import tn.pidev.FeatureComplaintSystem.Domain.Shipping;

import java.util.List;

public interface IComplaintApprovalService {
    Approval retriveApproval(Long approvalID);

    Approval ApprovalByModeratorName(String Name);

    void deleteApproval(Long approvalID);

    List<Approval> retriveALLApprovals();

    Approval updateApproval(Approval c);

    Approval addApproval(Approval a);


    void updateComplaintStatusByApproval(Long complaintId, ComplaintsStatus status);

    @Transactional
    void updateComplaintsShippmentForApprovedComplaints(Long complaintId, Shipping shippment);
}
