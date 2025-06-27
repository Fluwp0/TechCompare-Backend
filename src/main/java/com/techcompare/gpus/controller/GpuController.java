package com.techcompare.gpus.controller;

import com.techcompare.gpus.model.Gpu;
import com.techcompare.gpus.model.GpuModelAssembler;
import com.techcompare.gpus.service.GpuService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/gpus")
public class GpuController {

    private final GpuService service;
    private final GpuModelAssembler assembler;

    public GpuController(GpuService service, GpuModelAssembler assembler) {
        this.service   = service;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Gpu>> all() {
        List<EntityModel<Gpu>> gpus = service.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(gpus,
                linkTo(methodOn(GpuController.class).all()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Gpu> one(@PathVariable Long id) {
        Gpu gpu = service.findById(id)
                .orElseThrow(() -> new RuntimeException("GPU no encontrada: " + id));
        return assembler.toModel(gpu);
    }

    @PostMapping
    public EntityModel<Gpu> create(@RequestBody Gpu g) {
        Gpu saved = service.save(g);
        return assembler.toModel(saved);
    }

    @PutMapping("/{id}")
    public EntityModel<Gpu> update(@PathVariable Long id, @RequestBody Gpu g) {
        g.setId(id);
        Gpu updated = service.save(g);
        return assembler.toModel(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
