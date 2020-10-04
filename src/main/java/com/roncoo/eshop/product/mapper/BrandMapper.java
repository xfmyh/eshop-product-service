package com.roncoo.eshop.product.mapper;


import com.roncoo.eshop.product.model.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BrandMapper {

    @Insert("insert into brand(name,description) values(#{name},#{description})")
    void add(Brand brand);

    @Update("update brand set name = #{name},description = #{description} where id = #{id}")
    void update(Brand brand);

    @Delete("delete from brand where id = #{id}")
    void delete(Long id);

    @Select("select * from brand where id = #{id}")
    Brand findById(Long id);

    @Select("select * from brand where id in (${ids})")
    List<Brand> findByIds(@Param("ids") String ids);
}
