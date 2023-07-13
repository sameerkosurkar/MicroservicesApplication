package com.example.MicroservicesApplication.service;

import com.example.MicroservicesApplication.dto.Specimen;
import org.springframework.stereotype.Service;

public interface SpecimenService {

    Specimen fetchById(int id);

}
