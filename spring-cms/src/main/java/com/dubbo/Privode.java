package com.dubbo;/*
* @Description :
* @Date : 18:502018/3/27
* */

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Privode {
    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/hello");
    }
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"dubbo/dubboPrivodeContext.xml"});
        context.start();
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
