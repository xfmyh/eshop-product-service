package com.roncoo.eshop.product.mapper;


import com.roncoo.eshop.product.model.ProductSpecification;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductSpecificationMapper {

    @Insert("insert into product_specification(name,value,product_id) values(#{name},#{value},#{productId})")
    void add(ProductSpecification productSpecification);

    @Update("update product_specification set name = #{name},value = #{value},product_id = #{productId} where id = #{id}")
    void update(ProductSpecification productSpecification);

    @Delete("delete from product_specification where id = #{id}")
    void delete(Long id);

    @Select("select * from product_specification where id = #{id}")
    @Results({
            @Result(column = "product_id",property = "productId"),
    })
    ProductSpecification findById(Long id);

    @Select("select * from product_specification where product_id = #{productId}")
    @Results({
            @Result(column = "product_id",property = "productId"),
    })
    ProductSpecification findByProductId(Long productId);

}
