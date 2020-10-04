package com.roncoo.eshop.product.web.controller;


import com.roncoo.eshop.product.model.ProductSpecification;
import com.roncoo.eshop.product.service.ProductSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product-specification")
public class ProductSpecificationController {

    @Autowired
    private ProductSpecificationService productSpecificationService;


    @RequestMapping(value = "/add")
    @ResponseBody
    public String add(ProductSpecification productSpecification,String operationType) {
        try {
            productSpecificationService.add(productSpecification,operationType);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(ProductSpecification productSpecification,String operationType) {
        try {
            productSpecificationService.update(productSpecification,operationType);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(Long id,String operationType) {
        try {
            productSpecificationService.delete(id,operationType);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/findById")
    @ResponseBody
    public ProductSpecification findById(Long id) {
        try {
            return productSpecificationService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ProductSpecification();
    }


    @RequestMapping(value = "/findByProductId")
    @ResponseBody
    public ProductSpecification findByProductId(Long productId) {
        try {
            return productSpecificationService.findByProductId(productId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ProductSpecification();
    }
}
