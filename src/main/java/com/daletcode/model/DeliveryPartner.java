package com.daletcode.model;

import com.daletcode.enumeration.VehicleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name="tbl_delivery_partner")
public class DeliveryPartner extends BaseEntity{

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String firstName;

    private String lastName;

    @Column(name = "username", unique = true,nullable = false)
    private String username;

    private String password;

    private String gender;

    private Date dateOfBirth;

    @Column(name = "phone_number", unique = true,nullable = false)
    private String phoneNumber;

    private String email;

    private String address;

    private VehicleType vehicleType;

    private boolean available;
}
