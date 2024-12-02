package com.example.application.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Sponsor")
@NoArgsConstructor
@AllArgsConstructor
public class Sponsor {
    @Id
    @Column(name = "sponsorID")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sponsorID;

    @Nonnull
    @Column(length = 100, name = "sponsorName")
    @JsonProperty("sponsorName")
    private String sponsorName;

    // public Sponsor(String sponsorName, Integer sponsorID) {
    //     this.sponsorID = sponsorID;
    //     this.sponsorName = sponsorName;
    // }

    // public Integer getSponsorID() {
    //     return sponsorID;
    // }

    // public void setSponsorID(Integer sponsorID) {
    //     this.sponsorID = sponsorID;
    // }

    // public String getSponsorName() {
    //     return sponsorName;
    // }

    // public void setSponsorName(String sponsorName) {
    //     this.sponsorName = sponsorName;
    // }

}


