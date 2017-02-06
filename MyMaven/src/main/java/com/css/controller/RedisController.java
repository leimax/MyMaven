package com.css.controller;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping(value="/redis")
public class RedisController {	
	 @RequestMapping(value="/get",method=RequestMethod.GET)
	    public String hello(@RequestParam("key") String key,Model model){
		    Jedis jedis = new Jedis();
		    //jedis.set("ceshi", "����ͨ��......");
		    String str = null;
		    try {
				//Object obj = jedis.get("ceshi"); //ȡ�ַ���ֵ
		    	//Object obj = jedis.lpush("ceshi", 1); //��һ��ֵ���뵽�б�ͷ����value�����ظ��������б�ĳ���
		    	List<String> list = jedis.lrange(key, 0, -1);
		    	Object obj = list.toString();
		    	//Object obj = jedis.lindex("ceshi", 0);
				if (obj != null && obj instanceof String) {
					str = obj.toString();
				}  else if (obj != null) {
					str = JSONObject.toJSONString(obj);
				}
			} catch (RuntimeException e) {
				ExceptionUtils.getStackTrace(e);
			}		   
	        model.addAttribute("msg", str);
	        return "ceshi";
	    }
}
