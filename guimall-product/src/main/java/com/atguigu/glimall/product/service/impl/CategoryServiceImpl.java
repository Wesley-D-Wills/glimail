package com.atguigu.glimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.glimall.product.dao.CategoryDao;
import com.atguigu.glimall.product.entity.CategoryEntity;
import com.atguigu.glimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1、查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        // 2、组装成父子的树形结构
        // 2.1、找出所有的以及分类
        List<CategoryEntity> collect = entities.stream().filter(catefory -> catefory.getParentCid() == 0)
                .map(menu -> {
                    List<CategoryEntity> childrens = getChildrens(menu, entities);
                    menu.setChildren(childrens);
                    return menu;
                })
                .sorted((o1, o2) -> {
                    return (o1.getSort()==null?0:o1.getSort()) - (o2.getSort()==null?0:o2.getSort());
                }).collect(Collectors.toList());
        return collect;
    }

    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> entities) {
        List<CategoryEntity> collect = entities.stream().filter(categoryEntity -> root.getCatId() == categoryEntity.getParentCid())
                .map(categoryEntity -> {
                    List<CategoryEntity> childrens = getChildrens(categoryEntity, entities);
                    categoryEntity.setChildren(childrens);
                    return categoryEntity;
                }).sorted((o1, o2) -> {
                    return (o1.getSort()==null?0:o1.getSort()) - (o2.getSort()==null?0:o2.getSort());
                }).collect(Collectors.toList());
        return collect;
    }
}