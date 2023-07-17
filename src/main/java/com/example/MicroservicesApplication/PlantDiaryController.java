package com.example.MicroservicesApplication;

import com.example.MicroservicesApplication.dto.Specimen;
import com.example.MicroservicesApplication.service.SpecimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlantDiaryController {

    @RequestMapping("/")
    public String index(Model model) {
        Specimen specimen = new Specimen();
        specimen.setSpecimenId(69);
        model.addAttribute(specimen);
        return "index";
    }

    @RequestMapping("/sustainability")
    public String sustainability() {
        return "sustainability";
    }

    @Autowired
    SpecimenService specimenService;

    @RequestMapping("/saveSpecimen")
    public String save(Specimen specimen) {
        specimenService.save(specimen);
        return "index";
    }

    @RequestMapping("/plants")
    public ResponseEntity searchPlant(@RequestParam(value = "searchPlant", required = false) String searchPlant) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/specimen")
    @ResponseBody
    public ResponseEntity<List<Specimen>> fetchAll() {
        return new ResponseEntity<List<Specimen>>(specimenService.fetchAll(), HttpStatus.OK);
    }

    @GetMapping("/specimen/{id}")
    @ResponseBody
    public Specimen fetchById(@PathVariable("id") Integer id) {
        return specimenService.fetchById(id);
    }

    @PostMapping(value = "/specimen")
    public ResponseEntity<HttpStatus> saveSpecimen(@RequestBody Specimen specimen) {
        specimenService.save(specimen);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/specimen/{id}")
    public void updateSpecimen(@PathVariable("id") Integer id, @RequestBody Specimen specimen) {
        specimenService.update(id, specimen);
    }

    @DeleteMapping("/specimen/{id}")
    public void deleteSpecimen(@PathVariable("id") Integer id) {
        specimenService.delete(id);
    }

}
