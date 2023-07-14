package com.example.MicroservicesApplication.repository;

import com.example.MicroservicesApplication.dto.Specimen;

import java.util.List;

public interface SpecimenRepository {

    Specimen fetchById(int id);

    void save(Specimen specimen);

    List<Specimen> fetchAll();

    void update(Integer id, Specimen specimen);

    void delete(Integer id);
}
