package com.example.MicroservicesApplication;

import com.example.MicroservicesApplication.dto.LabelValue;
import com.example.MicroservicesApplication.dto.Plant;
import com.example.MicroservicesApplication.dto.Specimen;
import com.example.MicroservicesApplication.service.SpecimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
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

    @GetMapping(value = "/plants", consumes = "application/json", produces = "application/json")
    public ResponseEntity searchPlants(@RequestParam(value = "searchPlant", required = false, defaultValue = "None") String searchPlant) {
        try {
            List<Plant> plantList = specimenService.fetchPlants(searchPlant);
            return new ResponseEntity(plantList, HttpStatus.OK);
        } catch (IOException e) {
//            throw new RuntimeException(e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/plants")
    public String searchPlantsForm(@RequestParam(value = "searchPlant", required = false, defaultValue = "None") String searchPlant, Model model) {
        try {
            List<Plant> plantList = specimenService.fetchPlants(searchPlant);
            model.addAttribute("plants", plantList);
            return "plants";
        } catch (IOException e) {
            return "error";
        }
    }

    @RequestMapping("/plantNamesAutocomplete")
    @ResponseBody
    public List<LabelValue> plantNamesAutocomplete(@RequestParam("term") String term) throws IOException {
        List<LabelValue> suggestions = new ArrayList<LabelValue>();
        List<Plant> plants = specimenService.fetchPlants(term);
        for (Plant plant:plants) {
            LabelValue labelValue = new LabelValue();
            labelValue.setLabel(plant.getCommon());
            labelValue.setValue(plant.getId());
            suggestions.add(labelValue);
        }
        return suggestions;
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
