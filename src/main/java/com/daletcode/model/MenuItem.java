package com.daletcode.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name="tbl_menuItem")
public class MenuItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String code;

    private String name;

    private String description;

    private double price;

    private Integer availability;

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

}
