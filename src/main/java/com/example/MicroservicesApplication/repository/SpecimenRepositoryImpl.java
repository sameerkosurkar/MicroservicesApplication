package com.example.MicroservicesApplication.repository;

import com.example.MicroservicesApplication.dto.Specimen;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class SpecimenRepositoryImpl implements SpecimenRepository{

//    List <Specimen> specimens = new ArrayList<Specimen> ();

    HashMap<Integer, Specimen> specimens = new HashMap<>();

    @Override
    public Specimen fetchById(int id) {
        return specimens.get(id);
    }

    @Override
    public void save(Specimen specimen) {
        specimens.put(specimen.getSpecimenId(), specimen);
    }

    @Override
    public List<Specimen> fetchAll() {
        return new ArrayList<>(specimens.values());
    }

    @Override
    public void update(Integer id, Specimen specimen) {
        specimens.remove(id);
        specimens.put(specimen.getSpecimenId(), specimen);
    }

    @Override
    public void delete(Integer id) {
        specimens.remove(id);
    }

}
