package com.daletcode.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name="tbl_order_iterm")
public class OrderItem {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Integer quantity;

    private double price;

    private Long menuItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

}
