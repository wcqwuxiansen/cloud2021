package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String server_port;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if(result>0){
            return new CommonResult(200,"插入数据库成功,端口为:"+server_port,result);
        }

        return new CommonResult(444,"插入数据库失败",null);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return new CommonResult(200,"查询数据库成功,端口为:"+server_port,payment);
        }
        return new CommonResult(400,"没有对应的查询记录，id为："+id,null);
    }

    @GetMapping("/getDiscoveryClient")
    public DiscoveryClient getDiscoveryClient(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("************element:"+element+"**************");
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance serviceInstance : instances){
            log.info("********"+serviceInstance.getServiceId()+"****"+serviceInstance.getPort()+"****"+serviceInstance.getHost()+"******"+serviceInstance.getUri());
        }

        return this.discoveryClient;
    }
}

