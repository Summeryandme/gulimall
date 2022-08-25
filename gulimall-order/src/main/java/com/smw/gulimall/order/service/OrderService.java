package com.smw.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smw.common.utils.PageUtils;
import com.smw.gulimall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author smw
 * @email smwwhu@163.com
 * @date 2022-08-25 22:53:17
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

