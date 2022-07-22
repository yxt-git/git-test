package com.yxt.demo.order.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yxt.demo.order.entity.WorkEntity;
import com.yxt.demo.order.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-07-20 15:46:00
 */
public interface WorkService extends IService<WorkEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateOrder(WorkEntity work,String handler);
}

