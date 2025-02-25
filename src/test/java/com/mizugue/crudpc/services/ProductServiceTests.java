package com.mizugue.crudpc.services;

import com.mizugue.crudpc.dtos.ProductDTO;
import com.mizugue.crudpc.entities.Product;
import com.mizugue.crudpc.exceptions.exception.DatabaseException;
import com.mizugue.crudpc.exceptions.exception.ResourceNotFoundException;
import com.mizugue.crudpc.factories.ProductFactory;
import com.mizugue.crudpc.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository repository;

    @Mock
    private ModelMapper modelMapper;

    private Long existingId;
    private Long nonExistingId;
    private Long dependentId;
    private Product product;
    private ProductDTO productDTO;
    private PageImpl<Product> page;

    @BeforeEach
    void setUp() {
        existingId = 1L;
        nonExistingId = 100L;
        dependentId = 3L;
        product = ProductFactory.createProduct();
        productDTO = new ProductDTO();
        page = new PageImpl<>(List.of(product));

        // Mock comportamento do repository
        Mockito.when(repository.existsById(existingId)).thenReturn(true);
        Mockito.when(repository.existsById(nonExistingId)).thenReturn(false);
        Mockito.when(repository.existsById(dependentId)).thenReturn(true);

        Mockito.when(repository.findAll((Pageable) ArgumentMatchers.any())).thenReturn(page);
        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(product);

        Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(product));
        Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());

        // ModelMapper Mock
        Mockito.when(modelMapper.map(Mockito.any(Product.class), Mockito.eq(ProductDTO.class)))
               .thenReturn(productDTO);

        // Mock deletar
        Mockito.doNothing().when(repository).deleteById(existingId);
        Mockito.doThrow(org.springframework.dao.DataIntegrityViolationException.class)
               .when(repository).deleteById(dependentId);
    }

    @Test
    public void findByIdShouldReturnProductDTOWhenIdExists() {
        ProductDTO result = productService.findById(existingId);
        assertNotNull(result);
        Mockito.verify(repository, Mockito.times(1)).findById(existingId);
    }

    @Test
    public void findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {
        assertThrows(ResourceNotFoundException.class, () -> productService.findById(nonExistingId));
        Mockito.verify(repository, Mockito.times(1)).findById(nonExistingId);
    }

    @Test
    public void findAllShouldReturnPageOfProducts() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<ProductDTO> result = productService.findAll(pageable);

        assertNotNull(result);
        Mockito.verify(repository, Mockito.times(1)).findAll(pageable);
    }

    @Test
    public void deleteShouldNotThrowWhenIdExists() {
        assertDoesNotThrow(() -> productService.delete(existingId));
        Mockito.verify(repository, Mockito.times(1)).deleteById(existingId);
    }

    @Test
    public void deleteShouldThrowDatabaseExceptionWhenIdHasDependencies() {
        assertThrows(DatabaseException.class, () -> productService.delete(dependentId));
        Mockito.verify(repository, Mockito.times(1)).deleteById(dependentId);
    }

    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {
        assertThrows(ResourceNotFoundException.class, () -> productService.delete(nonExistingId));
        Mockito.verify(repository, Mockito.times(1)).existsById(nonExistingId);
    }
}