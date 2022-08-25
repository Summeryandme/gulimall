package com.smw.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smw.common.utils.PageUtils;
import com.smw.gulimall.member.entity.MemberStatisticsInfoEntity;

import java.util.Map;

/**
 * 会员统计信息
 *
 * @author smw
 * @email smwwhu@163.com
 * @date 2022-08-25 22:42:20
 */
public interface MemberStatisticsInfoService extends IService<MemberStatisticsInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

