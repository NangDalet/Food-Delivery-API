package com.daletcode.model;

import com.daletcode.enumeration.DeliveryStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name="tbl_delivery")
public class Delivery {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Temporal(TemporalType.TIME)
    private Date pickupTime = new Date();

    @Temporal(TemporalType.TIME)
    private Date deliveryTime = new Date();

    private String pickupAddress;

    private String deliveryAddress;

    private double deliveryFee;

    private DeliveryStatus deliveryStatus;

    private Long deliveryPartnerId;

    private Long orderId;

}
