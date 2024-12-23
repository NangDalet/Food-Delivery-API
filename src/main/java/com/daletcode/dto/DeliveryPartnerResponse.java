package com.daletcode.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeliveryPartnerResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("name")
    private String name;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("dob")
    private String dateOfBirth;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String email;

    @JsonProperty("address")
    private String address;

    @JsonProperty("vehicle")
    private String vehicle;

    @JsonProperty("available")
    private boolean available;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("updated_by")
    private String updatedBy;
}
