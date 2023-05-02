package tn.pidev.FeatureComplaintSystem.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pidev.FeatureComplaintSystem.Domain.Approval;
import tn.pidev.FeatureComplaintSystem.Domain.Complaint;
import tn.pidev.FeatureComplaintSystem.Domain.ComplaintsStatus;
import tn.pidev.FeatureComplaintSystem.Domain.Shipping;
import tn.pidev.FeatureComplaintSystem.Repo.ApprovalRepo;
import tn.pidev.FeatureComplaintSystem.Repo.ComplaintRepo;
import tn.pidev.FeatureComplaintSystem.Service.Interfaces.IComplaintApprovalService;

import java.util.List;

@Service
public class ApprovalService implements IComplaintApprovalService {


    @Autowired
    ApprovalRepo approvalRepo;
    @Autowired
    ComplaintRepo ComplaintRepo;

    @Autowired
    ComplaintService ComplaintService;

    @Override
    public Approval retriveApproval(Long ID) {
        return approvalRepo.findById(ID).get();
    }

    @Override
    public Approval ApprovalByModeratorName(String Name) {
        return approvalRepo.findByApprovedBy(Name);
    }

    @Override
    public void deleteApproval(Long approvalID) {
        approvalRepo.deleteById(approvalID);
    }

    @Override
    public List<Approval> retriveALLApprovals() {
        return approvalRepo.findAll();
    }


    @Override
    public Approval updateApproval(Approval c) {
        return approvalRepo.save(c);
    }

    @Override
    public Approval addApproval(Approval a) {
        return approvalRepo.save(a);
    }

    @Override
    @Transactional
    public void updateComplaintStatusByApproval(Long complaintId, ComplaintsStatus status) {
        Complaint complaint = ComplaintService.retriveCompaint(complaintId);
        complaint.setComplaintStatus(status);
        ComplaintRepo.save(complaint);
    }

    @Transactional
    @Override
    public void updateComplaintsShippmentForApprovedComplaints(Long complaintId, Shipping shippment) {
        List<Complaint> approvedComplaints = ComplaintRepo.findByIdAndComplaintStatus(complaintId,ComplaintsStatus.APPROVED );
        for (Complaint complaint : approvedComplaints) {
            List<Shipping> shippings = complaint.getShippings();
            shippings.add(shippment);
            complaint.setShippings(shippings);
            ComplaintRepo.save(complaint);
        }
    }




}
