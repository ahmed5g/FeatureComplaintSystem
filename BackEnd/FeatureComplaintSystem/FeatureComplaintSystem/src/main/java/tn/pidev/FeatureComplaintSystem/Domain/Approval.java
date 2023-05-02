package tn.pidev.FeatureComplaintSystem.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @OneToMany(fetch=FetchType.EAGER , mappedBy =  "approval")
    private Set<Complaint> complaints;



    @PrePersist
    public void prePersist(){
        this.approvedDate = LocalDateTime.now();
    }


}