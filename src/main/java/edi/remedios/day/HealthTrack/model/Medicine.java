package edi.remedios.day.HealthTrack.model;

import jakarta.persistence.*;


import java.time.LocalTime;



@Entity
@Table(name = "tb_medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private double dosagem;

    private String frequencia;

    private LocalTime horario;

    private String observacao;

    public Medicine() {}

    public Medicine(String name, double dosagem, String frequencia, LocalTime horario, String observacao) {
        setName(name);
        setDosagem(dosagem);
        setFrequencia(frequencia);
        setHorario(horario);
        setObservacao(observacao);
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

    public double getDosagem() {
        return dosagem;
    }

    public void setDosagem(double dosagem) {
        this.dosagem = dosagem;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
