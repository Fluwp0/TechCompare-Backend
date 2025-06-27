package com.techcompare.usuarios.controller;

import com.techcompare.usuarios.model.Usuario;
import com.techcompare.usuarios.model.UsuarioModelAssembler;
import com.techcompare.usuarios.service.UsuarioService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioModelAssembler assembler;

    public UsuarioController(UsuarioService service, UsuarioModelAssembler assembler) {
        this.service   = service;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Usuario>> all() {
        List<EntityModel<Usuario>> usuarios = service.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(usuarios,
                linkTo(methodOn(UsuarioController.class).all()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Usuario> one(@PathVariable Long id) {
        Usuario u = service.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));
        return assembler.toModel(u);
    }

    @PostMapping
    public EntityModel<Usuario> create(@RequestBody Usuario u) {
        Usuario saved = service.save(u);
        return assembler.toModel(saved);
    }

    @PutMapping("/{id}")
    public EntityModel<Usuario> update(@PathVariable Long id, @RequestBody Usuario u) {
        u.setId(id);
        Usuario updated = service.save(u);
        return assembler.toModel(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
