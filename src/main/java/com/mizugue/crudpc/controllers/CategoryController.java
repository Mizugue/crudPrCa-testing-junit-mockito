package com.mizugue.crudpc.controllers;

import com.mizugue.crudpc.dtos.CategoryDTO;
import com.mizugue.crudpc.services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping
    private ResponseEntity<List<CategoryDTO>> findAll(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    private ResponseEntity<CategoryDTO> delete(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.delete(id), HttpStatus.OK);

    }

    @PostMapping
    private ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.save(categoryDTO), HttpStatus.CREATED);

    }

    @PutMapping
    private ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.update(categoryDTO), HttpStatus.OK);

    }








}
