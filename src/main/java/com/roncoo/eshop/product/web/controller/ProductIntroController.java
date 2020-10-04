package com.roncoo.eshop.product.web.controller;


import com.roncoo.eshop.product.model.ProductIntro;
import com.roncoo.eshop.product.service.ProductIntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product-intro")
public class ProductIntroController {

    @Autowired
    private ProductIntroService productIntroService;


    @RequestMapping(value = "/add")
    @ResponseBody
    public String add(ProductIntro productIntro,String operationType) {
        try {
            productIntroService.add(productIntro,operationType);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(ProductIntro productIntro,String operationType) {
        try {
            productIntroService.update(productIntro,operationType);
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
            productIntroService.delete(id,operationType);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/findById")
    @ResponseBody
    public ProductIntro findById(Long id) {
        try {
            return productIntroService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ProductIntro();
    }
}
