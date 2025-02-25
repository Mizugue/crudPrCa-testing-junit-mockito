package com.mizugue.crudpc.services;


import com.mizugue.crudpc.dtos.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Page<ProductDTO> findAll(Pageable pageable);
    ProductDTO findById(Long id);
    ProductDTO delete(Long id);
    ProductDTO save(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);
}



