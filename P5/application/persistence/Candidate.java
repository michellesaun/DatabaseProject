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
@Table(name = "Candidate")
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    @Id
    @Column(name = "candidateID")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer candidateID;

    @Nonnull
    @Column(name = "memberID")
    @JsonProperty("memberID")
    private Integer memberID;

    @Nonnull
    @Column(length = 100, name = "position")
    @JsonProperty("position")
    private String position;

}


