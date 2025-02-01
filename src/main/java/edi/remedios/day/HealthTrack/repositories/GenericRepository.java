package edi.remedios.day.HealthTrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Classe genérica para o repositório
@Repository
public class GenericRepository<T, ID> {

    private final JpaRepository<T, ID> jpaRepository;

    public GenericRepository(JpaRepository<T, ID> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public T save(T entity) {
        return jpaRepository.save(entity);
    }

    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id);
    }

    public Iterable<T> findAll() {
        return jpaRepository.findAll();
    }

    public void deleteById(ID id) {
        jpaRepository.deleteById(id);
    }

    // Você pode adicionar outros métodos genéricos aqui conforme necessário
}
