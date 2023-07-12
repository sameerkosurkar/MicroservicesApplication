package com.example.MicroservicesApplication;

import com.example.MicroservicesApplication.dto.Specimen;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlantDiaryController {
    @RequestMapping("/")
    public String index() {
        Specimen specimen = new Specimen();
        specimen.setDescription("Foo");
        String desc = specimen.getDescription();
        return "start";
    }
}
