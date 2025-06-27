package com.techcompare.gpus.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.techcompare.gpus.model.Gpu;
import com.techcompare.gpus.repository.GpuRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final GpuRepository repository;

    public DataInitializer(GpuRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            repository.save(new Gpu("RTX 3060", 2021, 329, "12", "Ampere", 3584, "1320", "1777", "192", "170W", "/gpus/rtx3060.jpg"));
            repository.save(new Gpu("RTX 3070", 2020, 499, "8", "Ampere", 5888, "1500", "1725", "256", "220W", "/gpus/rtx3070.jpg"));
            // Añade aquí más GPUs según tu lista mock original
        }
    }
}
