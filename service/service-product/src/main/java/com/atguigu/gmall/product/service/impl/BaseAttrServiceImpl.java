package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.mapper.BaseAttrInfoMapper;
import com.atguigu.gmall.product.mapper.BaseAttrValueMapper;
import com.atguigu.gmall.product.service.BaseAttrService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseAttrServiceImpl implements BaseAttrService {


    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;

    /**
     * 根据id查询三级分类
     * @param category1Id
     * @param category2Id
     * @param category3Id
     * @return
     */
    @Override
    public List<BaseAttrInfo> getAttrInfoListByCategoryId(Long category1Id, Long category2Id, Long category3Id) {
        return baseAttrInfoMapper.getAttrInfoListByCategoryId(category1Id, category2Id, category3Id);
    }

    /**
     * 新增销售属性值
     * @param baseAttrInfo
     */
    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        //1、先保存baseAttrInfo基本信息
        baseAttrInfoMapper.insert(baseAttrInfo);
        //取出自动回填的id值
        Long attrInfoId = baseAttrInfo.getId();

        //2、再根据获取的id依次保存属性值
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        for (BaseAttrValue value : attrValueList) {
            value.setAttrId(attrInfoId);
            baseAttrValueMapper.insert(value);
        }

    }


//    @Override
//    //太麻烦了
//    public List<BaseAttrInfo> getAttrInfoListByCategoryId(Long category1Id, Long category2Id, Long category3Id) {
//        /**
//         * select * from base_attr_info
//         * where (category_id=2 and category_level=1) or
//         *       (category_id=13 and category_level=2) or
//         *     (category_id=61 and category_level=3)
//         */
//        QueryWrapper<BaseAttrInfo> wrapper = new QueryWrapper<>();
//        if(category1Id != 0){
//            //一级分类不为null
//            wrapper.eq("category_id",category1Id);
//            wrapper.eq("category_level",1);
//        }
//
//        if(category2Id != 0){
//            //二级分类不为null
//            QueryWrapper<BaseAttrInfo> or = wrapper.or();
//            or.eq("category_id",category2Id);
//            or.eq("category_level",2);
//        }
//
//
//        if(category3Id != 0){
//            //三级分类不为null
//            QueryWrapper<BaseAttrInfo> or = wrapper.or();
//            or.eq("category_id",category3Id);
//            or.eq("category_level",3);
//        }
//
//        //select * from baseAttrInfo
//        List<BaseAttrInfo> baseAttrInfos = baseAttrInfoMapper.selectList(wrapper);
//
//        return baseAttrInfos;
//    }
}
