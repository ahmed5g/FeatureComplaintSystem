package tn.pidev.FeatureComplaintSystem.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Complaint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;
    private String customerName;
    @Email
    private String customerEmail;
    private String customerAdress;
    private String orderID;
    private String description;
    @Enumerated
    private ComplaintsStatus complaintStatus;
    private String ShippingState;


    @OneToMany(cascade = CascadeType.ALL , mappedBy =  "complaint")

    private List<Shipping> shippings;
    @ManyToOne
    @JsonIgnore
    private Approval approval;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }

    public void starterStatue(){
        this.complaintStatus = ComplaintsStatus.IN_PROGRESS;
    }

    public void approve() {
        this.complaintStatus = ComplaintsStatus.APPROVED;
    }

    public void reject() {
        this.complaintStatus = ComplaintsStatus.REJECTED;
    }

    public Complaint(String customerEmail) {
        this.complaintStatus = ComplaintsStatus.PENDING;
    }
}
