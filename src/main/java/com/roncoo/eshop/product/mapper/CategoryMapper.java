package com.roncoo.eshop.product.mapper;


import com.roncoo.eshop.product.model.Category;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CategoryMapper {

    @Insert("insert into category(name,description) values(#{name},#{description})")
    void add(Category category);

    @Update("update category set name = #{name},description = #{description} where id = #{id}")
    void update(Category category);

    @Delete("delete from category where id = #{id}")
    void delete(Long id);

    @Select("select * from category where id = #{id}")
    Category findById(Long id);
}
