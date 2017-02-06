package com.css.framework;

import java.util.Map;

/**
 * 内容类
 * 
 * @author 陈圣圣 date 2017-02-05 17:00
 */
public interface ICache<K, V> {

	/**
	 * @author:陈圣圣
	 * @return String .
	 */
    String getCacheId();
    
	/**
	 * @author:陈圣圣
	 * @return V .
	 */
    V get(K key);
    
	/**
	 * @author:陈圣圣
	 * @return Map<K,V> .
	 */
    Map<K,V> get();
    
	/**
	 * @author:陈圣圣
	 * @return void .
	 */
    void invalid();
    
	/**
	 * @author:陈圣圣
	 * @return void .
	 */
    void invalid(K key);
    
	/**
	 * @author:陈圣圣
	 * @return void .
	 */
    void invalidMulti(K ... keys);
    
	/**
	 * @author:陈圣圣
	 * @return boolean .
	 */
    boolean refresh(K key);
    
	/**
	 * @author:陈圣圣
	 * @return boolean .
	 */
    long ttl(K key);
}
