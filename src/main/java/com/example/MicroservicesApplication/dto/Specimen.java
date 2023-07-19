package com.example.MicroservicesApplication.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Specimen {
    private Integer plantId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer specimenId;
    private String latitude;
    private String longitude;
    private String description;
}
