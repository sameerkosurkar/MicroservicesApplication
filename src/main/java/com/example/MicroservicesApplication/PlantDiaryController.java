package com.example.MicroservicesApplication;

import com.example.MicroservicesApplication.dto.Specimen;
import com.example.MicroservicesApplication.service.SpecimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class PlantDiaryController {

    @Autowired
    SpecimenService specimenService;

    @GetMapping("/specimen/")
    public ResponseEntity<List<Specimen>> fetchAll() {
        return new ResponseEntity<List<Specimen>>(specimenService.fetchAll(), HttpStatus.OK);
    }

    @GetMapping("/specimen/{id}/")
    public Specimen fetchById(@PathVariable("id") Integer id) {
        return specimenService.fetchById(id);
    }

    @PostMapping(value = "/specimen/")
    public ResponseEntity<HttpStatus> saveSpecimen(@RequestBody Specimen specimen) {
        specimenService.save(specimen);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/specimen/{id}/")
    public void updateSpecimen(@PathVariable("id") Integer id, @RequestBody Specimen specimen) {
        specimenService.update(id, specimen);
    }

    @DeleteMapping("/specimen/{id}/")
    public void deleteSpecimen(@PathVariable("id") Integer id) {
        specimenService.delete(id);
    }

}
