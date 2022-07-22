package com.yxt.demo.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yxt.demo.order.entity.WorkEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-07-20 15:46:00
 */
@Mapper
public interface WorkDao extends BaseMapper<WorkEntity> {
	
}
