package edi.remedios.day.HealthTrack.controller;

import edi.remedios.day.HealthTrack.model.Medicine;
import edi.remedios.day.HealthTrack.repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListaController {

    @Autowired
    private MedicineRepository medicineRepository;


    @GetMapping("/lista")
    public String exibirLista(Model model) {
        model.addAttribute("medicamentos", medicineRepository.findAll());
        return "lista"; // Retorna o template "lista.html"
    }
}