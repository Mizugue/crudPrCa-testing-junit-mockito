package com.mizugue.crudpc.factories;

import com.mizugue.crudpc.dtos.ProductDTO;
import com.mizugue.crudpc.entities.Product;

import java.util.HashSet;

public class ProductFactory {

    public static Product createProduct() {
        return new Product();
    }

    public static ProductDTO createProductDTO() {
        return new ProductDTO(1L, "jogo", "jogo legal", 200.0, "jdejfiejf", new HashSet<>());
    }

}
