package edi.remedios.day.HealthTrack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MedicinePageController {

    @GetMapping("/create")
    public String home() {
        return "createmedicine";
    }

    @GetMapping("/remedios")
    public String viewAllMedicines() {
        return "viewallmedicines";
    }
}
