package edi.remedios.day.HealthTrack.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
    public class Medicine {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String dosagem;

        @Enumerated(EnumType.STRING)
        private Frequencia frequencia;

        @Column(name = "data_hora_inicial")
        private LocalDateTime dataHoraInicial;

        @Column(name = "proxima_notificacao")
        private LocalDateTime proximaNotificacao;

        private String observacao;

        // Enum para frequências
        public enum Frequencia {
            DIARIA,
            ALTERNADOS,
            SEMANAL
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public Frequencia getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }

    public LocalDateTime getDataHoraInicial() {
        return dataHoraInicial;
    }

    public void setDataHoraInicial(LocalDateTime dataHoraInicial) {
        this.dataHoraInicial = dataHoraInicial;
    }

    public LocalDateTime getProximaNotificacao() {
        return proximaNotificacao;
    }

    public void setProximaNotificacao(LocalDateTime proximaNotificacao) {
        this.proximaNotificacao = proximaNotificacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}