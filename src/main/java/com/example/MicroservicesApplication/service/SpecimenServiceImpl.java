package com.example.MicroservicesApplication.service;

import com.example.MicroservicesApplication.dto.Specimen;
import com.example.MicroservicesApplication.repository.SpecimenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpecimenServiceImpl implements SpecimenService{

    @Autowired
    SpecimenRepository specimenRepository;
    @Override
    public Specimen fetchById(int id) {
        return specimenRepository.fetchById(id);
    }

    @Override
    public void save(Specimen specimen) {
        specimenRepository.save(specimen);
    }

    @Override
    public List<Specimen> fetchAll() {
        return specimenRepository.fetchAll();
    }

    @Override
    public void update(Integer id, Specimen specimen) {
        specimenRepository.update(id, specimen);
    }

    @Override
    public void delete(Integer id) {
        specimenRepository.delete(id);
    }

}
