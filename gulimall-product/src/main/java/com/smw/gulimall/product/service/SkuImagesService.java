package com.smw.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smw.common.utils.PageUtils;
import com.smw.gulimall.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author smw
 * @email smwwhu@163.com
 * @date 2022-08-25 20:25:54
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

