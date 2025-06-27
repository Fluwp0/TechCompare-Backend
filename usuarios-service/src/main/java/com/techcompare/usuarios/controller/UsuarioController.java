package com.techcompare.usuarios.controller;

import com.techcompare.usuarios.model.Usuario;
import com.techcompare.usuarios.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuario Controller", description = "CRUD de usuarios registrados en TechCompare")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Crear usuario", description = "Crea un nuevo usuario con los datos proporcionados.")
    public Usuario create(@RequestBody Usuario u) {
        return service.save(u);
    }

    @GetMapping
    @Operation(summary = "Listar usuarios", description = "Devuelve todos los usuarios registrados.")
    public List<Usuario> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por ID", description = "Devuelve un usuario específico según su ID.")
    public Usuario get(@PathVariable Long id) {
        return service.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar usuario", description = "Actualiza la información de un usuario por su ID.")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario u) {
        u.setId(id);
        return service.save(u);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar usuario", description = "Elimina un usuario del sistema según su ID.")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
