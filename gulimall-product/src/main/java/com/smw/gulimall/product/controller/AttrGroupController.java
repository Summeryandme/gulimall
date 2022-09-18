package com.smw.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smw.gulimall.product.entity.AttrGroupEntity;
import com.smw.gulimall.product.service.AttrGroupService;
import com.smw.common.utils.PageUtils;
import com.smw.common.utils.R;

@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
  @Autowired private AttrGroupService attrGroupService;

  @RequestMapping("/list/{catelogId}")
  public R list(@RequestParam Map<String, Object> params, @PathVariable Long catelogId) {
    PageUtils page = attrGroupService.queryPage(params, catelogId);

    return R.ok().put("page", page);
  }

  /** 信息 */
  @RequestMapping("/info/{attrGroupId}")
  public R info(@PathVariable("attrGroupId") Long attrGroupId) {
    AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);

    return R.ok().put("attrGroup", attrGroup);
  }

  /** 保存 */
  @RequestMapping("/save")
  public R save(@RequestBody AttrGroupEntity attrGroup) {
    attrGroupService.save(attrGroup);

    return R.ok();
  }

  /** 修改 */
  @RequestMapping("/update")
  public R update(@RequestBody AttrGroupEntity attrGroup) {
    attrGroupService.updateById(attrGroup);

    return R.ok();
  }

  /** 删除 */
  @RequestMapping("/delete")
  public R delete(@RequestBody Long[] attrGroupIds) {
    attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

    return R.ok();
  }
}
