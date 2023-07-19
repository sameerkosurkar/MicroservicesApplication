package com.example.MicroservicesApplication.dao;

import com.example.MicroservicesApplication.dto.Plant;

import java.io.IOException;
import java.util.List;

public interface PlantDAO {
    List<Plant> fetchPlants(String combinedName) throws IOException;
}
