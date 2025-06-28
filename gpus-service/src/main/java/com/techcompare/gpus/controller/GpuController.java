package com.techcompare.gpus.controller;

import com.techcompare.gpus.model.Gpu;
import com.techcompare.gpus.model.GpuModelAssembler;
import com.techcompare.gpus.service.GpuService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/gpus")
@Tag(name = "GPU Controller", description = "CRUD de GPUs disponibles en TechCompare con soporte HATEOAS")
public class GpuController {

    private final GpuService service;
    private final GpuModelAssembler assembler;

    public GpuController(GpuService service, GpuModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @PostMapping
    @Operation(summary = "Crear GPU", description = "Crea una nueva GPU con los datos proporcionados.")
    public EntityModel<Gpu> create(@RequestBody Gpu g) {
        Gpu saved = service.save(g);
        return assembler.toModel(saved);
    }

    @GetMapping
    @Operation(summary = "Listar GPUs", description = "Devuelve todas las GPUs registradas con enlaces HATEOAS.")
    public CollectionModel<EntityModel<Gpu>> all() {
        List<EntityModel<Gpu>> gpus = service.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(gpus,
            linkTo(methodOn(GpuController.class).all()).withSelfRel());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener GPU por ID", description = "Devuelve una GPU específica por su ID con enlaces HATEOAS.")
    public EntityModel<Gpu> get(@PathVariable Long id) {
        Gpu gpu = service.findById(id)
            .orElseThrow(() -> new RuntimeException("GPU no encontrada: " + id));
        return assembler.toModel(gpu);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar GPU", description = "Actualiza la información de una GPU según su ID.")
    public EntityModel<Gpu> update(@PathVariable Long id, @RequestBody Gpu g) {
        g.setId(id);
        Gpu updated = service.save(g);
        return assembler.toModel(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar GPU", description = "Elimina una GPU del sistema según su ID.")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
