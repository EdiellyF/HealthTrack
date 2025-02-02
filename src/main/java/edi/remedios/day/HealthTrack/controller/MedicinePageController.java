package edi.remedios.day.HealthTrack.controller;

import edi.remedios.day.HealthTrack.model.Medicine;
import edi.remedios.day.HealthTrack.repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicinePageController {

    @Autowired
    private MedicineRepository repository;


        @GetMapping("/cadastro")
        public String exibirFormulario(Model model) {
            model.addAttribute("medicine", new Medicine()); // Objeto "medicine" com campo "dosagem"
            return "cadastro";
        }

    @PostMapping("/create")
    public String salvarMedicine(@ModelAttribute Medicine medicine, BindingResult result) {
        if (result.hasErrors()) {
            return "cadastro"; // Mantém o usuário no formulário se houver erros
        }
        medicine.setProximaNotificacao(medicine.getDataHoraInicial()); // Define a primeira notificação
        repository.save(medicine);
        return "redirect:/lista";
    }
}