package com.atguigu.springcloud.controlller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String server_port;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul(){
        return "springcloud with consul: "+server_port+"\t   "+ UUID.randomUUID().toString();
    }
}
