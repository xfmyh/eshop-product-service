package com.roncoo.eshop.product.web.controller;


import com.roncoo.eshop.product.model.Product;
import com.roncoo.eshop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/add")
    @ResponseBody
    public String add(Product product,String operationType) {
        try {
            productService.add(product,operationType);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(Product product,String operationType) {
        try {
            productService.update(product,operationType);
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
            productService.delete(id,operationType);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/findById")
    @ResponseBody
    public Product findById(Long id) {
        try {
            return productService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Product();
    }
}
