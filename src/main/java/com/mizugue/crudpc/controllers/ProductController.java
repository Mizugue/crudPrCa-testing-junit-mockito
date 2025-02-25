package com.mizugue.crudpc.controllers;

import com.mizugue.crudpc.dtos.CategoryDTO;
import com.mizugue.crudpc.dtos.ProductDTO;
import com.mizugue.crudpc.services.CategoryServiceImpl;
import com.mizugue.crudpc.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {


    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    private ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable){
        return new ResponseEntity<>(productService.findAll(pageable), HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);

    }


    @DeleteMapping(value = "/{id}")
    private ResponseEntity<ProductDTO> delete(@PathVariable Long id){
        return new ResponseEntity<>(productService.delete(id), HttpStatus.OK);

    }

    @PostMapping
    private ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.save(productDTO), HttpStatus.CREATED);

    }

    @PutMapping
    private ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.update(productDTO), HttpStatus.OK);

    }




}
