package com.example.MicroservicesApplication.service;

import com.example.MicroservicesApplication.dto.Plant;
import com.example.MicroservicesApplication.dto.Specimen;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface SpecimenService {

    Specimen fetchById(int id);

    void save(Specimen specimen);

    List<Specimen> fetchAll();
    
    void update(Integer id, Specimen specimen);

    void delete(Integer id);

    List<Plant> fetchPlants(String combinedName) throws IOException;
}
