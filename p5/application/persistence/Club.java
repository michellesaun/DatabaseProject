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
@Table(name = "Club")
@NoArgsConstructor
@AllArgsConstructor
public class Club {
    @Id
    @Column(name = "clubID")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer clubID;

    @Nonnull
    @Column(length = 100, name = "clubName")
    @JsonProperty("clubName")
    private String clubName;

    @Nonnull
    @Column(name = "yearFounded")
    @JsonProperty("yearFounded")
    private Integer yearFounded;

}


