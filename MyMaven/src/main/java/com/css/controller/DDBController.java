package com.css.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.css.domain.User;
import com.css.service.ICusAccountService;

@Controller
@RequestMapping(value = "/ddb")
public class DDBController {
	@Resource(name="cusAccountService")
	private ICusAccountService cusAccountService;

	public void setCusAccountService(ICusAccountService cusAccountService) {
		this.cusAccountService = cusAccountService;
	}

	@RequestMapping(value = "/ddb", method = RequestMethod.GET)
	public String hello(@RequestParam("key") String key, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", Integer.valueOf(key));
		User user = cusAccountService.queryUserById(map);
		model.addAttribute("msg", user.getName());
		return "ddb";
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@RequestParam("key") String key, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", Integer.valueOf(key));
		User user = cusAccountService.queryUserById(map);
		model.addAttribute("msg", user.getName());
		return "ddb";
	}
	
}
