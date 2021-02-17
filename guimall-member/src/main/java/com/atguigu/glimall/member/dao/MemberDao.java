package com.atguigu.glimall.member.dao;

import com.atguigu.glimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author weixun
 * @email weixun1655@gmail.com
 * @date 2021-02-16 12:11:52
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
