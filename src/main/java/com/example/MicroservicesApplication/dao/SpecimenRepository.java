package com.example.MicroservicesApplication.dao;

import com.example.MicroservicesApplication.dto.Specimen;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("!test")
public interface SpecimenRepository extends CrudRepository<Specimen, Integer> {
}
