package com.daletcode.model;

import com.daletcode.enumeration.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_user")
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "username",nullable = false,unique = true)
    private String username;

    private String firstName;

    private String lastName;

    @Column(name = "gender", length = 10)
    private String gender;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private String email;

    @Column(name = "phone_number", length = 15,nullable = false)
    private String phoneNumber;

    private String address;

    @Column(name = "user_type")
    private UserType userType;

    private String status;
}
