package com.atguigu.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;


public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult(2020,"自定义限流处理信息___________handlerException1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(2020,"自定义限流处理信息___________handlerException2");
    }
}
