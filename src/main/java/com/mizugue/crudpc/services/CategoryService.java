package com.mizugue.crudpc.services;

import com.mizugue.crudpc.dtos.CategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> findAll();
    CategoryDTO findById(Long id);
    CategoryDTO delete(Long id);
    CategoryDTO save(CategoryDTO categoryDTO);
    CategoryDTO update(CategoryDTO categoryDTO);

}
