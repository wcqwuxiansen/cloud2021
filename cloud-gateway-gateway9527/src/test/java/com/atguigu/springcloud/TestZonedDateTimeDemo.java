package com.atguigu.springcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestZonedDateTimeDemo {

    @Test
    public void testZonedTiem(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
