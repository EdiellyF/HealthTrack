package edi.remedios.day.HealthTrack.repositories;

import edi.remedios.day.HealthTrack.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {


}
