package com.daletcode.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name="tbl_restaurant")
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;
    private String category;
    private String description;
    private double rating;
    private String address;
    private String phoneNumber;
    private String logoUrl;
    // @Temporal(TemporalType.TIME)
    private LocalTime openTime;
    // @Temporal(TemporalType.TIME)
    private LocalTime closeTime;
}
