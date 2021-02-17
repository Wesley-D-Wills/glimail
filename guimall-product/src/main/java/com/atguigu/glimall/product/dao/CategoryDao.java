package com.atguigu.glimall.product.dao;

import com.atguigu.glimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author weixun
 * @email weixun1655@gmail.com
 * @date 2021-02-15 12:19:58
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
