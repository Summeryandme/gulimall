package com.smw.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smw.common.utils.PageUtils;
import com.smw.gulimall.ware.entity.WareOrderTaskDetailEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author smw
 * @email smwwhu@163.com
 * @date 2022-08-25 22:57:18
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

