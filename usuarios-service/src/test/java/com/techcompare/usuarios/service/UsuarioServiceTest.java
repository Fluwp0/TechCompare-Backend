package com.techcompare.usuarios.service;

import com.techcompare.usuarios.model.Usuario;
import com.techcompare.usuarios.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    public UsuarioServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGuardarUsuario() {
        Usuario usuario = new Usuario("Maxi", "maxi@mail.com", "1234", "gpu1", "gpu2");
        usuario.setId(1L);

        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario resultado = usuarioService.save(usuario);

        assertNotNull(resultado);
        assertEquals("Maxi", resultado.getNombre());
    }

    @Test
    void testBuscarPorId() {
        Usuario usuario = new Usuario("Maxi", "maxi@mail.com", "1234", "gpu1", "gpu2");
        usuario.setId(1L);

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Optional<Usuario> resultado = usuarioService.findById(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Maxi", resultado.get().getNombre());
    }
}
