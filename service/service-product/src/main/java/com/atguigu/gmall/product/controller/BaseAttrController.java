package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.product.service.BaseAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 平台属性功能
 */
@RequestMapping("/admin/product")
@RestController
public class BaseAttrController {

    ///admin/product/attrInfoList/2/0/0

    @Autowired
    BaseAttrService baseAttrService;

    /**
     * 查询三级分类
     * @param category1Id
     * @param category2Id
     * @param category3Id
     * @return
     */
    @GetMapping("/attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result getAttrInfoList(@PathVariable("category1Id") Long category1Id,
                                  @PathVariable("category2Id") Long category2Id,
                                  @PathVariable("category3Id") Long category3Id){


      List<BaseAttrInfo> attrInfos = baseAttrService.getAttrInfoListByCategoryId(category1Id,category2Id,category3Id);
      return Result.ok(attrInfos);
    }

    /**
     * 保存销售属性值
     * @param baseAttrInfo
     * @return
     */
    @PostMapping("/saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo) {
        baseAttrService.saveAttrInfo(baseAttrInfo);
        return Result.ok();
    }

}
