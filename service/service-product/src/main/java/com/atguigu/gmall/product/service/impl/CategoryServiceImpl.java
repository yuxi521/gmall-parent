package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.product.mapper.BaseCategory2Mapper;
import com.atguigu.gmall.product.mapper.BaseCategory3Mapper;
import com.atguigu.gmall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    BaseCategory2Mapper baseCategory2Mapper;

    @Autowired
    BaseCategory3Mapper category3Mapper;  //setting里面搜autowire 去掉有关bean的那一项

    @Override
    public List<BaseCategory2> getCategory2(Long category1Id) {

        List<BaseCategory2> category2s = baseCategory2Mapper.getCategory2By1Id(category1Id);

        return category2s;
    }

    @Override
    public List<BaseCategory3> getCategory3(Long category2Id) {

        //select * from base_category3 where category2_id = #{category2Id}
        QueryWrapper<BaseCategory3> wrapper = new QueryWrapper<>();
        wrapper.eq("category2_id",category2Id);
        List<BaseCategory3> category3s = category3Mapper.selectList(wrapper);

        return category3s;
    }
}
