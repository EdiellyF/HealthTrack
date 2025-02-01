package edi.remedios.day.HealthTrack.services;

import edi.remedios.day.HealthTrack.model.Medicine;
import edi.remedios.day.HealthTrack.repositories.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService extends GenericService<Medicine, Long> {

    @Autowired
    public MedicineService(GenericRepository<Medicine, Long> repository) {
        super(repository);
    }

}
