package com.techcompare.usuarios.service;

import com.techcompare.usuarios.model.Usuario;
import com.techcompare.usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }
    public Usuario save(Usuario u) {
        return repo.save(u);
    }
    public List<Usuario> findAll() {
        return repo.findAll();
    }
    public Optional<Usuario> findById(Long id) {
        return repo.findById(id);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
