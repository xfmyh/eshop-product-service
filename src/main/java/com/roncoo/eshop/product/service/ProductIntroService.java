package com.roncoo.eshop.product.service;

import com.roncoo.eshop.product.model.ProductIntro;

public interface ProductIntroService {

    void add(ProductIntro productIntro,String operationType);

    void update(ProductIntro productIntro,String operationType);

    void delete(Long id,String operationType);

    ProductIntro findById(Long id);

}
