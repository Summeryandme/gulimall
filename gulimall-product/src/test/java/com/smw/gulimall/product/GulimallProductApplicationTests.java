package com.smw.gulimall.product;

import com.aliyun.oss.OSSClient;
import com.smw.gulimall.product.entity.BrandEntity;
import com.smw.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallProductApplicationTests {

  @Autowired BrandService brandService;

  @Autowired OSSClient ossClient;

  @Test
  void contextLoads() {
    BrandEntity brandEntity = new BrandEntity();
    brandEntity.setDescript("");
    brandEntity.setName("123");
    System.out.println(brandService.save(brandEntity));
  }


}
