package com.roncoo.eshop.product.web.controller;


import com.roncoo.eshop.product.model.Category;
import com.roncoo.eshop.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/add")
    @ResponseBody
    public String add(Category category,String operationType) {
        try {
            categoryService.add(category,operationType);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(Category category,String operationType) {
        try {
            categoryService.update(category,operationType);
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
            categoryService.delete(id,operationType);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/findById")
    @ResponseBody
    public Category findById(Long id) {
        try {
            return categoryService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Category();
    }
}
