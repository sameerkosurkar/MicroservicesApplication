package com.example.MicroservicesApplication.dao;

import com.example.MicroservicesApplication.dto.Specimen;
import org.springframework.data.repository.CrudRepository;

public interface SpecimenRepository extends CrudRepository<Specimen, Integer> {
}
