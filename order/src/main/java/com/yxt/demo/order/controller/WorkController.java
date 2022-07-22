package com.yxt.demo.order.controller;

import java.util.Arrays;
import java.util.Map;

import com.yxt.demo.order.utils.PageUtils;
import com.yxt.demo.order.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yxt.demo.order.entity.WorkEntity;
import com.yxt.demo.order.service.WorkService;




/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-07-20 15:46:00
 */
@RestController
@RequestMapping("order/work")
public class WorkController {
    @Autowired
    private WorkService workService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = workService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Integer userId){
		WorkEntity work = workService.getById(userId);

        return R.ok().put("work", work);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WorkEntity work){
        System.out.println(work);
        workService.save(work);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WorkEntity work,@RequestParam String handler){
		workService.updateOrder(work,handler);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] userIds){
		workService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}
