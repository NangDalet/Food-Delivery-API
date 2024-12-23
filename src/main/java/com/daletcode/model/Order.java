package com.daletcode.model;

import com.daletcode.enumeration.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name="tbl_order")
public class Order extends BaseEntity{

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "order_id")
    private String orderId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate = new Date();

    private double totalAmount;

    private double deliveryFee;

    private double tax;

    private double restaurantRating;

    private double deliveryRating;

    private OrderStatus orderStatus;

    private Long userId;

    private Long restaurantId;

    private Long deliveryId;

    private Long deliveryPartnerId;

    private Long paymentId;
}
