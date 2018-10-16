package com.spring.controller;

import com.activeMq.service.producer.queue.QueueSender;
import com.activeMq.service.producer.topic.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/activemq")
public class ActivemqController {
	@Autowired
	private QueueSender queueSender;
	@Autowired
	private TopicSender topicSender;
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/hello");
		return mav;
	}
	/**
	 * 发送消息到队列
	 * Queue队列：仅有一个订阅者会收到消息，消息一旦被处理就不会存在队列中
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping(value = "/queueSender",method = RequestMethod.POST)
	public String queueSender(@RequestParam("message")String message){
		String opt="";
		try {
			queueSender.send("test.queue", message);
			opt = "success";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}
	/**
	 * @Description :发送主题消息
	 * topic：所有订阅者会收到消息
	 * @Date : 2018/3/22
	 * @Params : [message, name]
	 * @Return : java.lang.String
	 * */
	@ResponseBody
	@RequestMapping(value = "/topicSender",method = RequestMethod.POST)
	public String topoicSender(@RequestParam("message")String message,String name){
		String opt = "";
		try {
			topicSender.send("test.topic", message);
			opt = "success";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}

}
