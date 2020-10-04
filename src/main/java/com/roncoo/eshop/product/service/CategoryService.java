package com.roncoo.eshop.product.service;

import com.roncoo.eshop.product.model.Category;

public interface CategoryService {

    void add(Category category,String operationType);

    void update(Category category,String operationType);

    void delete(Long id,String operationType);

    Category findById(Long id);

}
