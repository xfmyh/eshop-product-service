package com.roncoo.eshop.product.web.controller;


import com.roncoo.eshop.product.model.Brand;
import com.roncoo.eshop.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;


    @RequestMapping(value = "/add")
    @ResponseBody
    public String add(Brand brand,String operationType) {
        try {
            brandService.add(brand,operationType);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(Brand brand,String operationType) {
        try {
            brandService.update(brand,operationType);
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
            brandService.delete(id,operationType);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/findById")
    @ResponseBody
    public Brand findById(Long id) {
        try {
            return brandService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Brand();
    }

    @RequestMapping(value = "/findByIds")
    @ResponseBody
    public List<Brand> findByIds(String ids) {
        try {
            return brandService.findByIds(ids);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Arrays.asList(new Brand());
    }

}
