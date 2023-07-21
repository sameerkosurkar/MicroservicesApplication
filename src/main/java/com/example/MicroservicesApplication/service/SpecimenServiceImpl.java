package com.example.MicroservicesApplication.service;

import com.example.MicroservicesApplication.dao.PhotoDAO;
import com.example.MicroservicesApplication.dto.Photo;
import com.example.MicroservicesApplication.dto.Plant;
import com.example.MicroservicesApplication.dto.Specimen;
import com.example.MicroservicesApplication.dao.PlantDAO;
import com.example.MicroservicesApplication.dao.SpecimenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
@CacheConfig(cacheNames = "specimens")
public class SpecimenServiceImpl implements SpecimenService{

    @Autowired
    SpecimenDAO specimenDAO;

    @Autowired
    PhotoDAO photoDAO;

    @Autowired
    PlantDAO plantDAO;
    @Override
    @Cacheable(key = "#id")
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
    @CacheEvict(key = "#id")
    public void delete(Integer id) {
        specimenDAO.delete(id);
    }

    @Override
    @Cacheable("plants")
    public List<Plant> fetchPlants(String combinedName) throws IOException {
        return plantDAO.fetchPlants(combinedName);
    }

    @Override
    public void saveImage(MultipartFile imageFile, Photo photo) throws IOException {
        photoDAO.save(photo);
        photoDAO.saveImage(imageFile);
    }
}
