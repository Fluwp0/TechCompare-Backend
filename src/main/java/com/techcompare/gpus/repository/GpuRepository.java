package com.techcompare.gpus.repository;

import com.techcompare.gpus.model.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GpuRepository extends JpaRepository<Gpu, Long> {}
