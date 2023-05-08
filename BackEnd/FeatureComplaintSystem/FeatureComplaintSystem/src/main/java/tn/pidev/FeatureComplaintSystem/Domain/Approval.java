package tn.pidev.FeatureComplaintSystem.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
public class Approval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime approvedDate;
    private String approvedBy;


    @ManyToMany(mappedBy = "approvals")
    private Set<Complaint> Complaints = new HashSet<>();



    @PrePersist
    public void prePersist(){
        this.approvedDate = LocalDateTime.now();
    }


}