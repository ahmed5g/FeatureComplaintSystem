package tn.pidev.FeatureComplaintSystem.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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
    private LocalDate date;
    private String approvedBy;
    private ComplaintsStatus ActionOnComplaint;

    @OneToMany(fetch=FetchType.EAGER , mappedBy =  "approval")
    @JsonIgnore
    private List<Complaint> complaints;



}