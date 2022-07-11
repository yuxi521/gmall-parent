package com.atguigu.gmall.product.mapper;

import com.atguigu.gmall.model.product.BaseCategory2;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseCategory2Mapper extends BaseMapper<BaseCategory2> {


    List<BaseCategory2> getCategory2By1Id(@Param("category1Id") Long category1Id);


}
