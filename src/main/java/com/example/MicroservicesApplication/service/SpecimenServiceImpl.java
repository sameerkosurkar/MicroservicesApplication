package com.example.MicroservicesApplication.service;

import com.example.MicroservicesApplication.dto.Plant;
import com.example.MicroservicesApplication.dto.Specimen;
import com.example.MicroservicesApplication.dao.PlantDAO;
import com.example.MicroservicesApplication.dao.SpecimenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class SpecimenServiceImpl implements SpecimenService{

    @Autowired
    SpecimenDAO specimenDAO;

    @Autowired
    PlantDAO plantDAO;
    @Override
    public Specimen fetchById(int id) {
        return specimenDAO.fetchById(id);
    }

    @Override
    public void save(Specimen specimen) {
        specimenDAO.save(specimen);
    }

    @Override
    public List<Specimen> fetchAll() {
        return specimenDAO.fetchAll();
    }

    @Override
    public void update(Integer id, Specimen specimen) {
        specimenDAO.update(id, specimen);
    }

    @Override
    public void delete(Integer id) {
        specimenDAO.delete(id);
    }

    @Override
    public List<Plant> fetchPlants(String combinedName) throws IOException {
        return plantDAO.fetchPlants(combinedName);
    }

}
