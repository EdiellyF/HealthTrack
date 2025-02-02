package edi.remedios.day.HealthTrack.controller;

import edi.remedios.day.HealthTrack.model.Medicine;




import edi.remedios.day.HealthTrack.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MedicineController {

    private final GenericService<Medicine, Long> medicineService;

    @Autowired
    public MedicineController(GenericService<Medicine, Long> medicineService) {
        this.medicineService = medicineService;
    }



    @PostMapping("/create")
    public ResponseEntity<Medicine> createMedicine(Medicine medicine) {
        this.medicineService.save(medicine);
        return ResponseEntity.ok().body(medicine);
    }

    @GetMapping("/medicines")
    public ResponseEntity<List<Medicine>> getMedicines() {
        List<Medicine> medicines = medicineService.findAll();
        return ResponseEntity.ok(medicines);
    }

}
