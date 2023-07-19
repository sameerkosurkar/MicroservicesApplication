package com.example.MicroservicesApplication.dao;

import com.example.MicroservicesApplication.dto.Specimen;

import java.util.List;

public interface SpecimenDAO {

    Specimen fetchById(int id);

    void save(Specimen specimen);

    List<Specimen> fetchAll();

    void update(Integer id, Specimen specimen);

    void delete(Integer id);
}
