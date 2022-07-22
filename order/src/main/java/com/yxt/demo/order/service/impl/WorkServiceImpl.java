package com.yxt.demo.order.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yxt.demo.order.utils.PageUtils;
import com.yxt.demo.order.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.yxt.demo.order.dao.WorkDao;
import com.yxt.demo.order.entity.WorkEntity;
import com.yxt.demo.order.service.WorkService;


@Service("workService")
public class WorkServiceImpl extends ServiceImpl<WorkDao, WorkEntity> implements WorkService {

    /**
     * 工单列表与检索
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String userName = (String) params.get("userName");
        String title = (String) params.get("title");
        String state = (String) params.get("state");


        QueryWrapper<WorkEntity> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(userName)){
//            System.out.println("userName = " + userName);
            wrapper.like("user_name",userName);
        }
        if (!StringUtils.isEmpty(title)){
//            System.out.println("title = " + title);
            wrapper.like("title",title);
        }
        if (!StringUtils.isEmpty(state)){
            Integer s = new Integer(state);
            wrapper.eq("state",s);
        }

        IPage<WorkEntity> page = this.page(
                new Query<WorkEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }


    /**
     * 工单信息编辑
     * @param work
     */
    @Override
    public void updateOrder(WorkEntity work,String handler) {
        Integer state = work.getState();
        if (state == null){
            System.out.println("状态未提交");
        }

        WorkEntity entity = new WorkEntity();
        entity.setUserId(work.getUserId());
        entity.setHandSugg(work.getHandSugg());
        entity.setHandler(handler);
        if (state == 0){
            //未处理工单，将工单状态修改为已处理
            entity.setState(1);
        }
        baseMapper.updateById(entity);

    }
}