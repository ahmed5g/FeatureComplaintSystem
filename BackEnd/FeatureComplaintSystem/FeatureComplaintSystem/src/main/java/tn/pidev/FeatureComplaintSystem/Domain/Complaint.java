package tn.pidev.FeatureComplaintSystem.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
public class Complaint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private LocalDate requestDate;
    private String customerName;
    @Email
    private String customerEmail;
    private String customerAdress;
    private String order;
    private String Description;
    private Boolean isApproved;

    @OneToMany(cascade = CascadeType.ALL , mappedBy =  "complaint")
    @JsonIgnore
    private List<Shipping> shippings;
    @ManyToOne
    private Approval approval;


}