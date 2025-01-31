package edi.remedios.day.HealthTrack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedicineController {
    @GetMapping("/create")
    public String create() {
        return "createmedicine";
    }
}
