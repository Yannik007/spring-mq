package com.dubbo.service.impl;/*
* @Description :
* @Date : 15:102018/3/27
* */

import com.dubbo.service.MyService;
import org.springframework.stereotype.Service;

@Service("MyService")
public class MyServiceImpl implements MyService {
    public String sayhello(String name) {
        return "hello"+name;
    }
}
