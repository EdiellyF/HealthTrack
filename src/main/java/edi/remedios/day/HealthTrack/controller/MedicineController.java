package edi.remedios.day.HealthTrack.controller;

import edi.remedios.day.HealthTrack.model.Medicine;




import edi.remedios.day.HealthTrack.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class MedicineController {


    private final GenericService<Medicine, Long> medicineService;


    @Autowired
    public MedicineController(GenericService<Medicine, Long> medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/create")
    public String home() {
        return "createmedicine";
    }

    @PostMapping("/create")
    public ResponseEntity<Medicine> createMedicine(Medicine medicine) {
        this.medicineService.save(medicine);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicine);
    }

}
