package com.mizugue.crudpc.services;

import com.mizugue.crudpc.dtos.CategoryDTO;
import com.mizugue.crudpc.entities.Category;
import com.mizugue.crudpc.exceptions.exception.DatabaseException;
import com.mizugue.crudpc.exceptions.exception.ResourceNotFoundException;
import com.mizugue.crudpc.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(x -> modelMapper.map(x, CategoryDTO.class))
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public CategoryDTO findById(Long id) {
        return categoryRepository.findById(id)
                .map(x -> modelMapper.map(x, CategoryDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
    }

    @Transactional
    @Override
    public CategoryDTO delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        try {
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            throw new DatabaseException("Could not delete category with id: " + id);
        }
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Transactional
    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        categoryRepository.save(category);
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Transactional
    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(categoryDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryDTO.getId()));
        modelMapper.map(categoryDTO, category);
        categoryRepository.save(category);
        return modelMapper.map(category, CategoryDTO.class);
    }
}