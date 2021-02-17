package com.atguigu.glimall.product;

import com.atguigu.glimall.product.entity.BrandEntity;
import com.atguigu.glimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.function.Consumer;

@SpringBootTest
class GuimallProductApplicationTests {
    /**
     * 注入service
     * 测试里面提供的增删改查方法
     */
    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity entity = new BrandEntity();
        entity.setBrandId(13L);
        entity.setDescript("This is the first work");
//        entity.setName("Huawei");
//        brandService.save(entity);
//        System.out.println("保存成功...");

//        brandService.updateById(entity);
//        System.out.println("修改成功...");

        List<BrandEntity> brandList = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 13L));
        brandList.forEach(System.out::println);
    }

}
