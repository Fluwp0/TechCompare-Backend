package com.techcompare.usuarios.controller;

import com.techcompare.usuarios.model.Usuario;
import com.techcompare.usuarios.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService service;
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario u) {
        return service.save(u);
    }

    @GetMapping
    public List<Usuario> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Usuario get(@PathVariable Long id) {
        return service.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario u) {
        u.setId(id);
        return service.save(u);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
