package com.techcompare.usuarios.controller;

import com.techcompare.usuarios.model.Usuario;
import com.techcompare.usuarios.model.UsuarioModelAssembler;
import com.techcompare.usuarios.service.UsuarioService;
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
@RequestMapping("/api/usuarios")
@Tag(name = "Usuario Controller", description = "CRUD de usuarios registrados en TechCompare con soporte HATEOAS")
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioModelAssembler assembler;

    public UsuarioController(UsuarioService service, UsuarioModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @PostMapping
    @Operation(summary = "Crear usuario", description = "Crea un nuevo usuario con los datos proporcionados.")
    public EntityModel<Usuario> create(@RequestBody Usuario u) {
        Usuario saved = service.save(u);
        return assembler.toModel(saved);
    }

    @GetMapping
    @Operation(summary = "Listar usuarios", description = "Devuelve todos los usuarios registrados con enlaces HATEOAS.")
    public CollectionModel<EntityModel<Usuario>> all() {
        List<EntityModel<Usuario>> usuarios = service.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(usuarios,
                linkTo(methodOn(UsuarioController.class).all()).withSelfRel());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por ID", description = "Devuelve un usuario específico según su ID con enlaces HATEOAS.")
    public EntityModel<Usuario> get(@PathVariable Long id) {
        Usuario u = service.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));
        return assembler.toModel(u);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar usuario", description = "Actualiza la información de un usuario por su ID.")
    public EntityModel<Usuario> update(@PathVariable Long id, @RequestBody Usuario u) {
        u.setId(id);
        Usuario updated = service.save(u);
        return assembler.toModel(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar usuario", description = "Elimina un usuario del sistema según su ID.")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
