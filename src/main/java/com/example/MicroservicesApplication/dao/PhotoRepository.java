package com.example.MicroservicesApplication.dao;

import com.example.MicroservicesApplication.dto.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
