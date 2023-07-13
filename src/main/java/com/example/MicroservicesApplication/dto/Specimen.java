package com.example.MicroservicesApplication.dto;

import lombok.Data;

@Data
public class Specimen {
    private Integer plantId;
    private Integer specimenId;
    private String latitude;
    private String longitude;
    private String description;
}