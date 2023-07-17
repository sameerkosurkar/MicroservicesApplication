package com.example.MicroservicesApplication.repository;

import com.example.MicroservicesApplication.dto.Plant;

import java.io.IOException;
import java.util.List;

public interface PlantRespository {
    List<Plant> fetchPlants(String combinedName) throws IOException;
}
