package com.atguigu.glimall.ware.dao;

import com.atguigu.glimall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author weixun
 * @email weixun1655@gmail.com
 * @date 2021-02-16 12:27:50
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
