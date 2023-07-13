package com.example.MicroservicesApplication.service;

import com.example.MicroservicesApplication.dto.Specimen;
import org.springframework.stereotype.Component;

@Component
public class SpecimenServiceImpl implements SpecimenService{

    @Override
    public Specimen fetchById(int id) {
        Specimen specimen = new Specimen();
        specimen.setDescription("Redbud");
        specimen.setSpecimenId(83);
        return specimen;
    }

}
