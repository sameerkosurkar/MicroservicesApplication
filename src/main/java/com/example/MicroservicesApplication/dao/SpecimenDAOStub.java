package com.example.MicroservicesApplication.dao;

import com.example.MicroservicesApplication.dto.Specimen;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Profile("test")
public class SpecimenDAOStub implements SpecimenDAO {

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
    public void delete(Integer id) {
        specimens.remove(id);
    }

}
