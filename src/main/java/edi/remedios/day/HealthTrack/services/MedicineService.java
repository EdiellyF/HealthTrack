package edi.remedios.day.HealthTrack.services;

import edi.remedios.day.HealthTrack.model.Medicine;
import edi.remedios.day.HealthTrack.repositories.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MedicineService extends GenericService<Medicine, Long> {

    @Autowired
    public MedicineService(GenericRepository<Medicine, Long> repository) {
        super(repository);
    }

    public Medicine save(Medicine medicine){
        validateMedicine(medicine);
        return super.save(medicine);
    }


    private void validateMedicine(Medicine medicine) {
        if (medicine.getName() == null || medicine.getName().isBlank()) {
            throw new IllegalArgumentException("O nome do medicamento é obrigatório.");
        }

    }

}
