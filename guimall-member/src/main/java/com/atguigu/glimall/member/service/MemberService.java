package com.atguigu.glimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.glimall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author weixun
 * @email weixun1655@gmail.com
 * @date 2021-02-16 12:11:52
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

