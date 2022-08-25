package com.smw.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smw.common.utils.PageUtils;
import com.smw.gulimall.coupon.entity.HomeSubjectEntity;

import java.util.Map;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author smw
 * @email smwwhu@163.com
 * @date 2022-08-25 22:35:51
 */
public interface HomeSubjectService extends IService<HomeSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

