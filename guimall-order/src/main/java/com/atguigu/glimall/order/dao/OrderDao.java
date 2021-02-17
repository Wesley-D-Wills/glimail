package com.atguigu.glimall.order.dao;

import com.atguigu.glimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author weixun
 * @email weixun1655@gmail.com
 * @date 2021-02-16 12:23:11
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
