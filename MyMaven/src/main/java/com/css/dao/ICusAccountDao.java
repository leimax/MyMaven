package com.css.dao;

import java.util.Map;

import com.css.domain.User;


public interface ICusAccountDao {
	
	User queryUserById(Map<String, Object> map);
}
