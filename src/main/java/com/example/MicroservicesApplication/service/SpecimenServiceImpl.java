package com.example.MicroservicesApplication.service;

import com.example.MicroservicesApplication.dto.Plant;
import com.example.MicroservicesApplication.dto.Specimen;
import com.example.MicroservicesApplication.dao.PlantDAO;
import com.example.MicroservicesApplication.dao.SpecimenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(value = "specimen", key = "#id")
    public Specimen fetchById(int id) {
        return specimenDAO.fetchById(id);
    }

    @Override
    public void save(Specimen specimen) {
        specimenDAO.save(specimen);
    }

    @Override
    @Cacheable("specimens")
    public List<Specimen> fetchAll() {
        return specimenDAO.fetchAll();
    }

    @Override
    @CacheEvict(value = "specimen", key = "#id")
    public void delete(Integer id) {
        specimenDAO.delete(id);
    }

    @Override
    @Cacheable("plants")
    public List<Plant> fetchPlants(String combinedName) throws IOException {
        return plantDAO.fetchPlants(combinedName);
    }
}
