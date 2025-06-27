package com.techcompare.gpus.service;

import com.techcompare.gpus.model.Gpu;
import com.techcompare.gpus.repository.GpuRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GpuService {
    private final GpuRepository repo;
    public GpuService(GpuRepository repo) {
        this.repo = repo;
    }
    public Gpu save(Gpu g) {
        return repo.save(g);
    }
    public List<Gpu> findAll() {
        return repo.findAll();
    }
    public Optional<Gpu> findById(Long id) {
        return repo.findById(id);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
