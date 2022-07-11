package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.product.service.BaseCategory1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    BaseCategory1Service baseCategory1Service;

    @GetMapping("/hello")
    public List<BaseCategory1> getAll1(){

        return baseCategory1Service.list();
    }
}
