package com.css.service.impl;

import com.css.framework.CodisClient;
import com.css.service.ICodisDemoService;

//@Service
public class CodisDemoService implements ICodisDemoService {

    public CodisDemoService() {
        System.out.println(" CodisDemoService...................... ");
    }  
    
    //@Resource(name="codisClient")
	private CodisClient codisClient;
	
	public void setClient(CodisClient codisClient) {
		this.codisClient = codisClient;
	}

	public String queryCache(String key) {
		String str ="";
		str = String.valueOf(codisClient.getResource().get(key));
		System.out.println(str);
		return str;
	}
	
	public String insertCache(String key,String value) {
		String str = codisClient.getResource().set(key, value);
		System.out.println(str);
		return str;
	}
	


}
