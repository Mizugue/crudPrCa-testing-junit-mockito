package com.mizugue.crudpc.services;

import com.mizugue.crudpc.dtos.CategoryDTO;
import com.mizugue.crudpc.dtos.ProductDTO;
import com.mizugue.crudpc.entities.Category;
import com.mizugue.crudpc.entities.Product;
import com.mizugue.crudpc.exceptions.exception.DatabaseException;
import com.mizugue.crudpc.exceptions.exception.ResourceNotFoundException;
import com.mizugue.crudpc.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }


    @Transactional(readOnly = true)
    @Override
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(x -> modelMapper.map(x, ProductDTO.class));
    }



    @Transactional
    @Override
    public ProductDTO delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
        try {
            Product product = productRepository.getReferenceById(id); // Apenas pega a referência
            productRepository.deleteById(id);
            return modelMapper.map(product, ProductDTO.class);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new DatabaseException("Could not delete Product with id: " + id);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ProductDTO findById(Long id) {
        return productRepository.findById(id)
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    @Transactional
    @Override
    public ProductDTO save(ProductDTO productDTO) {
        productRepository.save(modelMapper.map(productDTO, Product.class));
        return productDTO;
    }

    @Transactional
    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("id not found " + productDTO.getId()));
        modelMapper.map(productDTO, product);
        productRepository.save(product);
        return modelMapper.map(product, ProductDTO.class);


    }
}



