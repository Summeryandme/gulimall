package com.smw.gulimall.order.dao;

import com.smw.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author smw
 * @email smwwhu@163.com
 * @date 2022-08-25 22:53:17
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
