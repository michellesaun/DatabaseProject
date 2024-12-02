package com.example.application.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "StudentCouncil")
@NoArgsConstructor
@AllArgsConstructor
public class StudentCouncil {
    @Id
    @Column(length = 100, name = "email")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String email;

    @Nonnull
    @Column(length = 100, name = "website")
    @JsonProperty("website")
    private String website;

    @Nonnull
    @Column(length = 100, name = "phone")
    @JsonProperty("phone")
    private String phone;

}


