package edi.remedios.day.HealthTrack.services;

import edi.remedios.day.HealthTrack.model.Medicine;
import edi.remedios.day.HealthTrack.repositories.MedicineRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
@EnableScheduling
public class NotificationScheduler {

    @Autowired
    private MedicineRepository medicineRepository;

    @Scheduled(cron = "0 * * * * *") // Executa a cada minuto
    public void verificarNotificacoes() {
        LocalDateTime agora = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        List<Medicine> medicamentos = medicineRepository.findByProximaNotificacao(agora);

        for (Medicine med : medicamentos) {
            enviarNotificacao(med);
            atualizarProximaNotificacao(med);
            medicineRepository.save(med); // Atualiza a próxima notificação
        }
    }

    private void enviarNotificacao(Medicine medicine) {
        System.out.println("[NOTIFICAÇÃO] Hora de tomar " + medicine.getName()
                + " - Próxima dose: " + medicine.getProximaNotificacao());
    }

    private void atualizarProximaNotificacao(Medicine medicine) {
        switch (medicine.getFrequencia()) {
            case DIARIA:
                medicine.setProximaNotificacao(
                        medicine.getProximaNotificacao().plusDays(1)
                );
                break;
            case ALTERNADOS:
                medicine.setProximaNotificacao(
                        medicine.getProximaNotificacao().plusDays(2)
                );
                break;
            case SEMANAL:
                medicine.setProximaNotificacao(
                        medicine.getProximaNotificacao().plusWeeks(1)
                );
                break;
            default:
                break;
        }
    }
}