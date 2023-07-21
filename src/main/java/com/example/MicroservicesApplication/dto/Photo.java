package com.example.MicroservicesApplication.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue
    Integer photoId;
    String photographer;
    String path;
    String filename;
    String comments;

    @ManyToOne
    @JoinColumn
    Specimen specimen;
}
