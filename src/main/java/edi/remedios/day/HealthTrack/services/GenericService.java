package edi.remedios.day.HealthTrack.services;

import edi.remedios.day.HealthTrack.repositories.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenericService<T, ID> {


    private final GenericRepository<T, ID> genericRepository;

    @Autowired
    public GenericService(GenericRepository<T, ID> genericRepository) {
        this.genericRepository = genericRepository;
    }



    public T save(T entity) {
        return genericRepository.save(entity);
    }


    public Optional<T> findById(ID id) {
        return genericRepository.findById(id);
    }


    public List<T> findAll() {
        return (List<T>) genericRepository.findAll();
    }


    public void deleteById(ID id) {
        genericRepository.deleteById(id);
    }

}

