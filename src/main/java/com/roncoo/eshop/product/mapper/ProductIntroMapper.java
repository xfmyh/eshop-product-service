package com.roncoo.eshop.product.mapper;


import com.roncoo.eshop.product.model.ProductIntro;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductIntroMapper {

    @Insert("insert into product_intro(content,product_id) values(#{content},#{productId})")
    void add(ProductIntro productIntro);

    @Update("update product_intro set content = #{content},product_id = #{productId} where id = #{id}")
    void update(ProductIntro productIntro);

    @Delete("delete from product_intro where id = #{id}")
    void delete(Long id);

    @Select("select * from product_intro where id = #{id}")
    @Results({
            @Result(column = "product_id",property = "productId"),
    })
    ProductIntro findById(Long id);
}
