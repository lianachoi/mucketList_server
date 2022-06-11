package com.liana.DWShop.item.controller.repository;

import com.liana.DWShop.item.model.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ItemRepository {
    @Select("select * from items where parent_Id = 0")
    List<Item> findAll();
    @Select("SELECT * FROM items WHERE parent_id = #{id} ")
    List<Item> findById(long id);

}
