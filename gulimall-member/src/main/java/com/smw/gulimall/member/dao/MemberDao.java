package com.smw.gulimall.member.dao;

import com.smw.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author smw
 * @email smwwhu@163.com
 * @date 2022-08-25 22:42:20
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
