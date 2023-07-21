package com.example.MicroservicesApplication.service;

import com.example.MicroservicesApplication.dto.Plant;
import com.example.MicroservicesApplication.dto.Specimen;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SpecimenService {

    Specimen fetchById(int id);

    void save(Specimen specimen);

    List<Specimen> fetchAll();

    void delete(Integer id);

    List<Plant> fetchPlants(String combinedName) throws IOException;

    void saveImage(MultipartFile imageFile) throws IOException;
}
