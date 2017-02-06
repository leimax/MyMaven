package com.css.service;

public interface ICodisDemoService {
	String queryCache(String key);
	String insertCache(String key,String value);
}