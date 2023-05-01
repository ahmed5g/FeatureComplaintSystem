package tn.pidev.FeatureComplaintSystem.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Shipping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Shipping_ID;
    private LocalDate Shipping_date;
    //address of the store from which the package is sent
    private String sender_address;
    //address of the customer who ordered the package
    private String recipient_address;
    private String Tracking_number;
    private Float shipping_cost;
    private String replacement_item;
    private ShippmentStatus delivery_status;
    @ManyToOne(fetch = FetchType.LAZY)
    private Complaint complaint;



}
