package com.liana.DWShop.item.controller.repository;

import com.liana.DWShop.item.model.Option;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OptionRepository {

    @Select("SELECT * FROM options WHERE item_id = #{id} ")
    List<Option> findById(long id);
}
