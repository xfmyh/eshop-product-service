package com.roncoo.eshop.product.web.controller;


import com.roncoo.eshop.product.model.ProductProperty;
import com.roncoo.eshop.product.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product-property")
public class ProductPropertyController {

    @Autowired
    private ProductPropertyService productPropertyService;


    @RequestMapping(value = "/add")
    @ResponseBody
    public String add(ProductProperty productProperty,String operationType) {
        try {
            productPropertyService.add(productProperty,operationType);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(ProductProperty productProperty,String operationType) {
        try {
            productPropertyService.update(productProperty,operationType);
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
            productPropertyService.delete(id,operationType);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/findById")
    @ResponseBody
    public ProductProperty findById(Long id) {
        try {
            return productPropertyService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ProductProperty();
    }

    @RequestMapping(value = "/findByProductId")
    @ResponseBody
    public ProductProperty findByProductId(Long productId) {
        try {
            return productPropertyService.findByProductId(productId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ProductProperty();
    }

}
