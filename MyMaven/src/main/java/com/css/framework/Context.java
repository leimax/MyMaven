package com.css.framework;

/**
 * 内容类
 * 
 * @author 陈圣圣 date 2017-02-05 17:00
 */
public class Context {

    /**
     * 缓存
     */
    private ICache<?, ?> cache;

    /**
     * 缓存
     */
    public Context(ICache<?, ?> cache) {
        this.cache = cache;
    }
    
    /**
     * 缓存id
     */
    public String getCacheId() {
        return this.cache.getCacheId();
    }
    
}
