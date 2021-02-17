package com.atguigu.glimall.coupon.dao;

import com.atguigu.glimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author weixun
 * @email weixun1655@gmail.com
 * @date 2021-02-16 12:03:28
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
