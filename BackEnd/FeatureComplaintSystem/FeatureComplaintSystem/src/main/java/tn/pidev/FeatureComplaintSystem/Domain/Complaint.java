package tn.pidev.FeatureComplaintSystem.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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


    @OneToMany(mappedBy =  "complaint")
    private Set<Shipping> Shippings = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "complaint_Approval",
            joinColumns = @JoinColumn(name = "complaint_id"),
            inverseJoinColumns = @JoinColumn(name = "approval_id")
    )
    private Set<Approval> approvals = new HashSet<>();


    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }


}
