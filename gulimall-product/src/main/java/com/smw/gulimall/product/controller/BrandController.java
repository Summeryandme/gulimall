package com.smw.gulimall.product.controller;

import com.smw.common.utils.PageUtils;
import com.smw.common.utils.R;
import com.smw.common.valid.AddGroup;
import com.smw.common.valid.UpdateGroup;
import com.smw.gulimall.product.entity.BrandEntity;
import com.smw.gulimall.product.service.BrandService;
import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 品牌
 *
 * @author smw
 * @email smwwhu@163.com
 * @date 2022-08-25 21:40:18
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
  @Autowired private BrandService brandService;

  /** 列表 */
  @RequestMapping("/list")
  public R list(@RequestParam Map<String, Object> params) {
    PageUtils page = brandService.queryPage(params);

    return R.ok().put("page", page);
  }

  /** 信息 */
  @RequestMapping("/info/{brandId}")
  public R info(@PathVariable("brandId") Long brandId) {
    BrandEntity brand = brandService.getById(brandId);

    return R.ok().put("brand", brand);
  }

  /** 保存 */
  @RequestMapping("/save")
  public R save(@Validated(value = AddGroup.class) @RequestBody BrandEntity brand) {
    brandService.save(brand);
    return R.ok();
  }

  /** 修改 */
  @RequestMapping("/update")
  public R update(@Validated(value = UpdateGroup.class) @RequestBody BrandEntity brand) {
    brandService.updateById(brand);

    return R.ok();
  }

  /** 删除 */
  @RequestMapping("/delete")
  public R delete(@RequestBody Long[] brandIds) {
    brandService.removeByIds(Arrays.asList(brandIds));

    return R.ok();
  }
}
