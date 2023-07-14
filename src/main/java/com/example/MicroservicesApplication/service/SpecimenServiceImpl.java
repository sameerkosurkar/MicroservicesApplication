package com.example.MicroservicesApplication.service;

import com.example.MicroservicesApplication.dto.Specimen;
import com.example.MicroservicesApplication.repository.SpecimenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpecimenServiceImpl implements SpecimenService{

    @Autowired
    SpecimenRepository specimenRepository;
    @Override
    public Specimen fetchById(int id) {
        return specimenRepository.fetchById(id);
    }

}
