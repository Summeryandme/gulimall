package com.smw.gulimall.product.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smw.common.utils.PageUtils;
import com.smw.common.utils.Query;

import com.smw.gulimall.product.dao.AttrGroupDao;
import com.smw.gulimall.product.entity.AttrGroupEntity;
import com.smw.gulimall.product.service.AttrGroupService;

@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity>
    implements AttrGroupService {

  @Override
  public PageUtils queryPage(Map<String, Object> params) {
    IPage<AttrGroupEntity> page =
        this.page(new Query<AttrGroupEntity>().getPage(params), new QueryWrapper<>());

    return new PageUtils(page);
  }

  @Override
  public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
    IPage<AttrGroupEntity> page;
    if (catelogId == 0) {
      page = this.page(new Query<AttrGroupEntity>().getPage(params), new QueryWrapper<>());
      return new PageUtils(page);
    }

    String key = (String) params.get("key");
    QueryWrapper<AttrGroupEntity> queryWrapper =
        new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId);
    if (!StringUtils.isEmpty(key)) {
      queryWrapper.and(obj -> obj.eq("attr_group_id", key).or().like("attr_group_name", key));
    }
    page = this.page(new Query<AttrGroupEntity>().getPage(params), queryWrapper);
    return new PageUtils(page);
  }
}
