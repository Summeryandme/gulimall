package com.smw.gulimall.coupon.dao;

import com.smw.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author smw
 * @email smwwhu@163.com
 * @date 2022-08-25 22:35:51
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
