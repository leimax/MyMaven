package com.css.service;

import java.util.Map;

import com.css.domain.User;


public interface ICusAccountService{
	
	User queryUserById(Map<String, Object> map);	
}
