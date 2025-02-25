package com.mizugue.crudpc.dtos;

import com.mizugue.crudpc.entities.Product;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


import java.util.HashSet;
import java.util.Set;

public class CategoryDTO {

    private Long id;
    private String name;


    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public CategoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

