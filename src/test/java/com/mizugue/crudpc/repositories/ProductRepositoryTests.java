package com.mizugue.crudpc.repositories;

import com.mizugue.crudpc.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;


    @Test
    public void findByIdShouldReturnOptionalProductNotNullWhenIdDoesExist(){
        Optional<Product> product = productRepository.findById(1L);
        Assertions.assertNotNull(product);
    }

    @Test
    public void findByIdShouldReturnOptionalProductNullWhenIdDoesNotExist(){
        Optional<Product> product = productRepository.findById(20L);
        Assertions.assertTrue(product.isEmpty());
    }

}
