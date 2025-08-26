package com.payoyo.gestion_ferreteria.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.payoyo.gestion_ferreteria.dto.CreateProductoDTO;
import com.payoyo.gestion_ferreteria.dto.ProductoResponseDTO;
import com.payoyo.gestion_ferreteria.exception.ProductoNoEncontradoException;
import com.payoyo.gestion_ferreteria.model.Producto; 
import com.payoyo.gestion_ferreteria.mapper.ProductoMapper;
import com.payoyo.gestion_ferreteria.repository.ProductoRepository;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {
    
    @Mock
    private ProductoRepository productoRepository;

    @Mock
    private ProductoMapper productoMapper;

    @InjectMocks
    private ProductoServiceImpl productoService;

    private Producto producto1;
    private Producto producto2;

    @BeforeEach
    void setUp() {
        producto1 = new Producto();
        producto1.setId(1L);
        producto1.setNombre("Martillo");

        producto2 = new Producto();
        producto2.setId(2L);
        producto2.setNombre("Destornillador");
    }

    @Test
    void testFindAllProductos() {
        // GIVEN
        List<Producto> productos = Arrays.asList(producto1, producto2);

        ProductoResponseDTO productoDTO1 = new ProductoResponseDTO(
            producto1.getId(),
            producto1.getNombre(),
            null, // categoría
            null, // precio
            null, // stock
            null  // activo
        );

        ProductoResponseDTO productoDTO2 = new ProductoResponseDTO(
            producto2.getId(),
            producto2.getNombre(),
            null,
            null,
            null,
            null
        );

        when(productoRepository.findAll()).thenReturn(productos);
        when(productoMapper.toDTO(producto1)).thenReturn(productoDTO1);
        when(productoMapper.toDTO(producto2)).thenReturn(productoDTO2);

        // WHEN
        List<ProductoResponseDTO> resultado = productoService.buscarTodos();

        // THEN
        assertThat(resultado).isNotNull();
        assertThat(resultado).hasSize(2);
        assertThat(resultado).containsExactly(productoDTO1, productoDTO2);

        verify(productoRepository).findAll();
        verify(productoMapper).toDTO(producto1);
        verify(productoMapper).toDTO(producto2);
    }

    @Test
    void textBuscarPorIdExiste(){
        Long id = 1L;

        Producto producto = new Producto();
        producto.setId(id);
        producto.setNombre("Martillo");

        ProductoResponseDTO productoDTO = new ProductoResponseDTO(
            id,
            "Martillo",
            null,
            null,
            null,
            null
        );

        when(productoRepository.findById(id)).thenReturn(Optional.of(producto));
        when(productoMapper.toDTO(producto)).thenReturn(productoDTO);

        //WHEN
        ProductoResponseDTO resultado = productoService.obtenerPorId(id);

        //THEN
        assertThat(resultado).isNotNull();
        assertThat(resultado).isEqualTo(productoDTO);

        verify(productoRepository).findById(id);
        verify(productoMapper).toDTO(producto);
    }

    @Test
    void buscarPorIdNoExiste(){
        Long id = 99L;

        when(productoRepository.findById(id)).thenReturn(Optional.empty());

        // WHEN & THEN
        assertThatThrownBy(() -> productoService.obtenerPorId(id))
            .isInstanceOf(ProductoNoEncontradoException.class)
            .hasMessageContaining("No se encontro ningún producto con ID: 99");

    }

    @Test
    void testCrearProducto(){
        CreateProductoDTO createDTO = new CreateProductoDTO(
            "Martillo",
            "Ferreteria",
            12.99,
            50
        );

        Producto producto = new Producto();
        producto.setId(1L); 
        producto.setNombre("Martillo");
        producto.setCategoria("Ferretería");
        producto.setPrecio(12.99);
        producto.setStock(50);
        producto.setActivo(true);

        ProductoResponseDTO responseDTO = new ProductoResponseDTO(
            1L,
            "Martillo",
            "Ferretería",
            12.99,
            50,
            true
        );

        //GIVEN
        when(productoMapper.toEntity(createDTO)).thenReturn(producto);
        when(productoRepository.save(producto)).thenReturn(producto);
        when(productoMapper.toDTO(producto)).thenReturn(responseDTO);

        // WHEN
        ProductoResponseDTO resultado = productoService.crear(createDTO);

        // THEN
        assertThat(resultado).isNotNull();
        assertThat(resultado).isEqualTo(responseDTO);

        verify(productoMapper).toEntity(createDTO);
        verify(productoRepository).save(producto);
        verify(productoMapper).toDTO(producto);
    }

    @Test
    void testActualizarProductoExiste(){
        Long id = 1L;

        // Simula el producto actual guardado en la base de datos
        Producto productoExistente = new Producto();
        productoExistente.setId(id);
        productoExistente.setNombre("Martillo Viejo");
        productoExistente.setCategoria("Ferretería");
        productoExistente.setPrecio(10.00);
        productoExistente.setStock(20);
        productoExistente.setActivo(true);

        // Simula el producto después de ser actualizado
        Producto productoActualizado = new Producto();
        productoActualizado.setId(id);
        productoActualizado.setNombre("Martillo Pro");
        productoActualizado.setCategoria("Ferretería");
        productoActualizado.setPrecio(15.99);
        productoActualizado.setStock(40);
        productoActualizado.setActivo(true);

        // DTO de respuesta esperado
        ProductoResponseDTO responseDTO = new ProductoResponseDTO(
            id,
            "Martillo Pro",
            "Ferretería",
            15.99,
            40,
            true
        );

        lenient().when(productoRepository.findById(id)).thenReturn(Optional.of(productoExistente));
        lenient().when(productoRepository.save(productoExistente)).thenReturn(productoActualizado);
        lenient().when(productoMapper.toDTO(productoActualizado)).thenReturn(responseDTO);

    }

    @Test
    void testActualizarProductoNoExiste() {
        Long id = 99L;
        CreateProductoDTO updateDTO = new CreateProductoDTO("Taladro", "Herramientas", 35.99, 15);

        when(productoRepository.findById(id)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productoService.actualizar(id, updateDTO))
            .isInstanceOf(ProductoNoEncontradoException.class)
            .hasMessageContaining("No se encontro");

        verify(productoRepository).findById(id);
        verifyNoMoreInteractions(productoRepository);
        verifyNoInteractions(productoMapper);
    }

    @Test
    void testEliminarProducto() {
        Long id = 1L;

        Producto producto = new Producto();
        producto.setId(id);
        producto.setNombre("Martillo");
        producto.setActivo(true);

        Producto productoActualizado = new Producto();
        productoActualizado.setId(id);
        productoActualizado.setNombre("Martillo");
        productoActualizado.setActivo(false);

        ProductoResponseDTO responseDTO = new ProductoResponseDTO(
            id, "Martillo", null, null, null, false
        );

        when(productoRepository.findById(id)).thenReturn(Optional.of(producto));
        when(productoRepository.save(producto)).thenReturn(productoActualizado);
        when(productoMapper.toDTO(productoActualizado)).thenReturn(responseDTO);

        ProductoResponseDTO resultado = productoService.eliminar(id);

        assertThat(resultado).isNotNull();
        assertThat(resultado).isEqualTo(responseDTO);
        assertThat(resultado.activo()).isFalse();

        verify(productoRepository).findById(id);
        verify(productoRepository).save(producto);
        verify(productoMapper).toDTO(productoActualizado);
    }

    @Test
    void testEliminarProductoNoExiste() {
        Long id = 99L;

        when(productoRepository.findById(id)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productoService.eliminar(id))
            .isInstanceOf(ProductoNoEncontradoException.class)
            .hasMessageContaining("No se encontro");

        verify(productoRepository).findById(id);
        verifyNoMoreInteractions(productoRepository);
        verifyNoInteractions(productoMapper);
    }



}
