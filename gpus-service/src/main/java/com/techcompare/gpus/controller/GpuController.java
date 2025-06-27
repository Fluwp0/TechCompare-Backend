package com.techcompare.gpus.controller;

import com.techcompare.gpus.model.Gpu;
import com.techcompare.gpus.service.GpuService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/gpus")
public class GpuController {
    private final GpuService service;
    public GpuController(GpuService service) {
        this.service = service;
    }

    @PostMapping
    public Gpu create(@RequestBody Gpu g) {
        return service.save(g);
    }

    @GetMapping
    public List<Gpu> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Gpu get(@PathVariable Long id) {
        return service.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Gpu update(@PathVariable Long id, @RequestBody Gpu g) {
        g.setId(id);
        return service.save(g);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
