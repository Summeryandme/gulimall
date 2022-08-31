package com.smw.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smw.common.utils.PageUtils;
import com.smw.common.utils.Query;
import com.smw.gulimall.product.dao.CategoryDao;
import com.smw.gulimall.product.entity.CategoryEntity;
import com.smw.gulimall.product.service.CategoryService;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity>
    implements CategoryService {

  @Override
  public PageUtils queryPage(Map<String, Object> params) {
    IPage<CategoryEntity> page =
        this.page(new Query<CategoryEntity>().getPage(params), new QueryWrapper<>());

    return new PageUtils(page);
  }

  @Override
  public List<CategoryEntity> listWithTree() {
    List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
    categoryEntities.forEach(
        categoryEntity ->
            categoryEntity.setChildrenCategory(
                getChildrenCategoriesById(categoryEntity.getCatId())));
    return categoryEntities.stream()
        .filter(categoryEntity -> categoryEntity.getCatLevel() == 1)
        .collect(Collectors.toList());
  }

  private List<CategoryEntity> getChildrenCategoriesById(Long id) {
    List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
    return categoryEntities.stream()
        .filter(categoryEntity -> Objects.equals(categoryEntity.getParentCid(), id))
        .map(
            categoryEntity -> {
              categoryEntity.setChildrenCategory(
                  getChildrenCategoriesById(categoryEntity.getCatId()));
              return categoryEntity;
            })
        .collect(Collectors.toList());
  }
}
