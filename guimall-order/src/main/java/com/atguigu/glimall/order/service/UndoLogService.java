package com.atguigu.glimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.glimall.order.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author weixun
 * @email weixun1655@gmail.com
 * @date 2021-02-16 12:23:11
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

