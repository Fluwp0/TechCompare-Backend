package com.techcompare.gpus.service;

import com.techcompare.gpus.model.Gpu;
import com.techcompare.gpus.repository.GpuRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GpuServiceTest {

    @Mock
    private GpuRepository gpuRepository;

    @InjectMocks
    private GpuService gpuService;

    public GpuServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGuardarGpu() {
        Gpu gpu = new Gpu("RTX 3080", 2022, 999.99, "10GB", "GDDR6X", 8704,
                          "1.44GHz", "1.71GHz", "320-bit", "320W", "url-imagen");
        gpu.setId(1L);

        when(gpuRepository.save(gpu)).thenReturn(gpu);

        Gpu resultado = gpuService.save(gpu);

        assertNotNull(resultado);
        assertEquals("RTX 3080", resultado.getModel());
    }

    @Test
    void testBuscarPorId() {
        Gpu gpu = new Gpu("RTX 3080", 2022, 999.99, "10GB", "GDDR6X", 8704,
                          "1.44GHz", "1.71GHz", "320-bit", "320W", "url-imagen");
        gpu.setId(1L);

        when(gpuRepository.findById(1L)).thenReturn(Optional.of(gpu));

        Optional<Gpu> resultado = gpuService.findById(1L);

        assertTrue(resultado.isPresent());
        assertEquals("RTX 3080", resultado.get().getModel());
    }
}
