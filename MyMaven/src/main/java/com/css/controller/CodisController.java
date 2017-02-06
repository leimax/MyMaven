package com.css.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.css.service.ICodisDemoService;

@Controller
@RequestMapping(value = "/codis")
public class CodisController {

	public ICodisDemoService codisDemoService;

	public void setCodisDemoService(ICodisDemoService codisDemoService) {
		this.codisDemoService = codisDemoService;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String hello(@RequestParam("key") String key, Model model) {
		System.out.println("=================================" + key);
		String str = "原始值";
		str = codisDemoService.queryCache(key);
		model.addAttribute("msg", str);
		return "ceshi";
	}

	@RequestMapping(value = "/set", method = RequestMethod.GET)
	public String sethello(@RequestParam("key") String key,@RequestParam("value") String value, Model model) {

		String str = "";
		try {
			str = new String(value.getBytes("iso8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("codis 缓存设置值 [KEY]:" + key + "[VALUE]:" + str);
		
		str = codisDemoService.insertCache(key,str);
		model.addAttribute("msg", str);
		return "ceshi";
	}

}
