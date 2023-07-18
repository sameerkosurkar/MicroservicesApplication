package com.example.MicroservicesApplication.dto;

import lombok.Data;

@Data
public class Specimen {
    private String plantId;
    private Integer specimenId;
    private String latitude;
    private String longitude;
    private String description;
}
