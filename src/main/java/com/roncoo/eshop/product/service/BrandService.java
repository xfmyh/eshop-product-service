package com.roncoo.eshop.product.service;

import com.roncoo.eshop.product.model.Brand;

import java.util.List;

public interface BrandService {

    void add(Brand brand,String operationType);

    void update(Brand brand,String operationType);

    void delete(Long id,String operationType);

    Brand findById(Long id);

    List<Brand> findByIds(String ids);

}
