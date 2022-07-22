package com.yxt.demo.order.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-07-20 15:46:00
 */
@Data
@TableName("work")
public class WorkEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@TableId(type = IdType.AUTO)
	private Integer userId;
	/**
	 * 客户姓名
	 */
	private String userName;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 工单名称（标题）
	 */
	private String title;
	/**
	 * 问题描述
	 */
	private String description;
	/**
	 * 处理人
	 */
	private String handler;
	/**
	 * 处理建议
	 */
	private String handSugg;
	/**
	 * 工单处理状态 0--未处理 1--已处理
	 */
	private Integer state;
	/**
	 * 工单创建时间
	 */
	private Date createTime;

}
