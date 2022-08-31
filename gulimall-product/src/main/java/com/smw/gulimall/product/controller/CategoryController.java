package com.smw.gulimall.product.controller;

import com.smw.common.utils.R;
import com.smw.gulimall.product.entity.CategoryEntity;
import com.smw.gulimall.product.service.CategoryService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product/category")
public class CategoryController {
  @Autowired private CategoryService categoryService;

  @RequestMapping("/list/tree")
  public R list() {
    List<CategoryEntity> entities = categoryService.listWithTree();

    return R.ok().put("data", entities);
  }

  /** 信息 */
  @RequestMapping("/info/{catId}")
  public R info(@PathVariable("catId") Long catId) {
    CategoryEntity category = categoryService.getById(catId);

    return R.ok().put("category", category);
  }

  /** 保存 */
  @RequestMapping("/save")
  public R save(@RequestBody CategoryEntity category) {
    categoryService.save(category);

    return R.ok();
  }

  /** 修改 */
  @RequestMapping("/update")
  public R update(@RequestBody CategoryEntity category) {
    categoryService.updateById(category);

    return R.ok();
  }

  /** 删除 */
  @RequestMapping("/delete")
  public R delete(@RequestBody Long[] catIds) {
    categoryService.removeByIds(Arrays.asList(catIds));

    return R.ok();
  }
}
