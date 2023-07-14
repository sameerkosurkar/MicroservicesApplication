package com.example.MicroservicesApplication.repository;

import com.example.MicroservicesApplication.dto.Specimen;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpecimenRepositoryImpl implements SpecimenRepository{

    List <Specimen> specimens;

    @Override
    public Specimen fetchById(int id) {
        Specimen specimen = new Specimen();
        specimen.setDescription("Redbud");
        return specimen;
    }
}
