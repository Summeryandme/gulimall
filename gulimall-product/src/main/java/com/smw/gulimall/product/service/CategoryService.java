package com.smw.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smw.common.utils.PageUtils;
import com.smw.gulimall.product.entity.CategoryEntity;
import java.util.List;
import java.util.Map;

public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeCategoriesByIds(List<Long> ids);
}

