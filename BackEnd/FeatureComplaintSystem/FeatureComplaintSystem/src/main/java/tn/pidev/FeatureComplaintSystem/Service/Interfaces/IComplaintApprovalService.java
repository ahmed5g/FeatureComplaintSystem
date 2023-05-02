package tn.pidev.FeatureComplaintSystem.Service.Interfaces;

import tn.pidev.FeatureComplaintSystem.Domain.Approval;
import tn.pidev.FeatureComplaintSystem.Domain.Complaint;
import tn.pidev.FeatureComplaintSystem.Domain.ComplaintsStatus;

import java.util.List;

public interface IComplaintApprovalService {
    Approval retriveApproval(Long approvalID);

    Approval ApprovalByModeratorName(String Name);

    void deleteApproval(Long approvalID);

    List<Approval> retriveALLApprovals();

    Approval updateApproval(Approval c);

    Approval addApproval(Approval a);


    void updateComplaintStatusByApproval(Long complaintId, ComplaintsStatus status);
}
