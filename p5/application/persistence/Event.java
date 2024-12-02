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
@Table(name = "Event")
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @Column(name = "eventID")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventID;

    @Nonnull
    @Column(length = 100, name = "eventName")
    @JsonProperty("eventName")
    private String eventName;

    @Nonnull
    @Column(length = 100, name = "eventDate")
    @JsonProperty("eventDate")
    private String eventDate;

}


