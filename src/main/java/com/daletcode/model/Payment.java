package com.daletcode.model;

import com.daletcode.enumeration.PaymentMethod;
import com.daletcode.enumeration.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_payment")
public class Payment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Double amount;

    private PaymentMethod paymentMethod;

    private PaymentStatus paymentStatus;

    private String description;

    private Long orderId;
}
