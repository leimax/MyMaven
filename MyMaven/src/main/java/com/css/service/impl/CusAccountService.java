package com.css.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.css.dao.ICusAccountDao;
import com.css.domain.User;
import com.css.service.ICusAccountService;

@Service
public class CusAccountService implements ICusAccountService{
    public CusAccountService() {
        System.out.println(" CusAccountService...................... ");
    }
	@Resource(name="cusAccountDao")
	private ICusAccountDao cusAccountDao;
	
	public void setCusAccountDao(ICusAccountDao cusAccountDao) {
		this.cusAccountDao = cusAccountDao;
	}


	public User queryUserById(Map<String, Object> map) {
		
		return cusAccountDao.queryUserById(map);
	}
	

}
