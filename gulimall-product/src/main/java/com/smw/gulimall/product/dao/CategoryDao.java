package com.smw.gulimall.product.dao;

import com.smw.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author smw
 * @email smwwhu@163.com
 * @date 2022-08-25 20:25:54
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
