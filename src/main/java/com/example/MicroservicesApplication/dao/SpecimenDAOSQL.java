package com.example.MicroservicesApplication.dao;

import com.example.MicroservicesApplication.dto.Specimen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("!test")
public class SpecimenDAOSQL implements SpecimenDAO{

    @Autowired
    SpecimenRepository specimenRepository;

    @Override
    public Specimen fetchById(int id) {
        Specimen specimen = specimenRepository.findById(id).get();
        return specimen;
    }

    @Override
    public void save(Specimen specimen) {
        specimenRepository.save(specimen);
    }

    @Override
    public List<Specimen> fetchAll() {
        Iterable<Specimen> allSpecimens = specimenRepository.findAll();
        List<Specimen> specimens = new ArrayList<>();
        for (Specimen specimen: allSpecimens) {
            specimens.add(specimen);
        }
        return specimens;
    }

    @Override
    public void update(Integer id, Specimen specimen) {
        Specimen oldSpecimen = specimenRepository.findById(id).get();
        oldSpecimen.setDescription(specimen.getDescription());
        oldSpecimen.setLatitude(specimen.getLatitude());
        oldSpecimen.setLongitude(specimen.getLongitude());
        oldSpecimen.setPlantId(specimen.getPlantId());
    }

    @Override
    public void delete(Integer id) {
        specimenRepository.deleteById(id);
    }
}
