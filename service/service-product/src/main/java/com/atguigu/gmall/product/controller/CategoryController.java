package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.product.service.BaseCategory1Service;
import com.atguigu.gmall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 处理所有和分类有关的请求
 * /admin/product/getCategory1
 */
@RequestMapping("/admin/product")
@RestController
public class CategoryController {

    @Autowired
    BaseCategory1Service baseCategory1Service;

    @Autowired
    CategoryService categoryService;

    /**
     * 获取所有的一级分类
     * @return
     */
    @GetMapping("/getCategory1")
    public Result<List<BaseCategory1>> getCategory1() {

        List<BaseCategory1> list = baseCategory1Service.list();

        return Result.ok(list);
    }

    /**
     * 根据1级分类的id，查出所有的二级分类
     * @param category1Id
     * @return
     */
    @GetMapping("/getCategory2/{category1Id}")
    public Result<List<BaseCategory2>> getCategory2(@PathVariable("category1Id") Long category1Id) {
        List<BaseCategory2> category2s = categoryService.getCategory2(category1Id);

        return Result.ok(category2s);
    }



    @GetMapping("/getCategory3/{category2Id}")
    public Result<List<BaseCategory3>> getCategory3(@PathVariable("category2Id") Long category2Id){

        List<BaseCategory3> category3s =   categoryService.getCategory3(category2Id);

        return Result.ok(category3s);
    }
}
