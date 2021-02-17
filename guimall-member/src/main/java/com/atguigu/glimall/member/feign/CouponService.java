package com.atguigu.glimall.member.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("guimall-coupon")
public interface CouponService {
    @RequestMapping("/coupon/coupon/test")
    public R test();
}
