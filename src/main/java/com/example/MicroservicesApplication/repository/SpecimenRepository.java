package com.example.MicroservicesApplication.repository;

import com.example.MicroservicesApplication.dto.Specimen;

public interface SpecimenRepository {

    Specimen fetchById(int id);
}
