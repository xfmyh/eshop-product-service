package com.roncoo.eshop.product.service;

import com.roncoo.eshop.product.model.ProductProperty;

public interface ProductPropertyService {

    void add(ProductProperty productProperty,String operationType);

    void update(ProductProperty productProperty,String operationType);

    void delete(Long id,String operationType);

    ProductProperty findById(Long id);

    ProductProperty findByProductId(Long productId);

}
