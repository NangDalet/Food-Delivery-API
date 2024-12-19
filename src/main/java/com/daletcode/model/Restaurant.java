package com.daletcode.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name="tbl_restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String code;

    private String name;

    private String category;

    private double rating;

    private String address;

    private String phoneNumber;

    private String logoUrl;

    @Temporal(TemporalType.TIME)
    private Date openTime;

    @Temporal(TemporalType.TIME)
    private Date closeTime;

}
