package com.css.framework;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

import com.wandoulabs.jodis.JedisResourcePool;
import com.wandoulabs.jodis.RoundRobinJedisPool;
/**
 * Codis类
 * 
 * @author 陈圣圣 date 2017-02-05 17:00
 */
public class CodisClient {

	// LOG
	Log log = LogFactory.getLog(getClass());
	// jedis pool 
	private JedisPoolConfig poolConfig;

	public void setPoolConfig(JedisPoolConfig poolConfig) {
		this.poolConfig = poolConfig;
	}

	/** jedis */
	private AtomicBoolean poolInited = new AtomicBoolean(false);
	// j池
	private JedisResourcePool jedisPool;

	public JedisResourcePool getJedisPool() {
		return jedisPool;
	}
	
	private String host = "localhost";
	
	private String password;
	// 时间
	private int timeout = 3000;

	public int getTimeout() {
		return timeout;
	}

	// ZK
	private String zkProxyDir;

	/**
	 * 资源文件之后初始
	 */
	@PostConstruct 
	public void afterPropertiesSet() throws Exception {
		init();
	}

	/**
	 * 初始
	 */
	private void init() {
		try {
			if (jedisPool != null)
				jedisPool.close();
			jedisPool = RoundRobinJedisPool.create()
					.curatorClient(host, timeout).password(password)
					.zkProxyDir(zkProxyDir).poolConfig(poolConfig).build();
			poolInited.set(true);
			log.info("DPAP-CodisClient init ........................................ ");
		} catch (IOException e) {
			poolInited.set(false);
			e.printStackTrace();
		}
	}

	/** 获取池信息 */
	public boolean getPoolInited() {
		return poolInited.get();
	}

	/** 断开连接  */
	private void disconnect(Jedis jedis) {
		jedis.disconnect();
	}

	/** 获取资源  */
	public Jedis getResource() {
		return jedisPool.getResource();
	}

	/**  返回资源  */
	public void returnResource(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}

	public void returnBrokenResource(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}
	@PreDestroy
	public void destroy() {
		if (null != jedisPool.getResource()) {
			if (jedisPool.getResource().isConnected()) {
				disconnect(jedisPool.getResource());
			}
		}
		log.info("redis destory........................................ ");
	}

	/** 获得池信息  */
	public JedisPoolConfig getPoolConfig() {
		if (poolConfig == null) {
			poolConfig = new JedisPoolConfig();
			poolConfig.setMaxTotal(1024);
			poolConfig.setMaxIdle(200);
			poolConfig.setMaxWaitMillis(1000);
			poolConfig.setTestOnBorrow(false);
			poolConfig.setTestOnReturn(false);
		}
		return poolConfig;
	}

	public void setJedisPool(JedisResourcePool jedisPool) {
		this.jedisPool = jedisPool;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public void setZkProxyDir(String zkProxyDir) {
		this.zkProxyDir = zkProxyDir;
	}
}
