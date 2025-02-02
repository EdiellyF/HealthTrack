package edi.remedios.day.HealthTrack.repositories;

import edi.remedios.day.HealthTrack.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findByProximaNotificacao(LocalDateTime proximaNotificacao);
}