package com.css.framework;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class RedisClient {

	Log log = LogFactory.getLog(getClass());

	private JedisPool pool;

	private JedisPoolConfig poolConfig = null;

	public void setPoolConfig(JedisPoolConfig poolConfig) {
		this.poolConfig = poolConfig;
	}

	private AtomicBoolean poolInited = new AtomicBoolean(false);

	private String host = "localhost";

	private int port = Protocol.DEFAULT_PORT;

	private String password;

	private int timeout = 3000;

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		init();
	}

	private void init() {
		Jedis j = null;
		try {
			j = new Jedis(host, port, timeout);
			if (StringUtils.isNotBlank(password)) {
				j.auth(password);
			} else {
				j.ping();
			}
			initPool(host, port, timeout, password);
			poolInited.set(true);
		} catch (JedisConnectionException e) {
			poolInited.set(false);
			log.error(e.getMessage(), e);
		} finally {
			if (j != null)
				disconnect(j);
		}
	}

	private void initPool(String host, int port, int timeout, String password) {
		if (pool != null)
			pool.destroy();
		pool = new JedisPool(getPoolConfig(), host, port, timeout, password);
		log.info("DPAP-RedisClient初始成功......");
	}

	public boolean getPoolInited() {
		return poolInited.get();
	}

	private void disconnect(Jedis jedis) {
		jedis.disconnect();
	}

	public Jedis getResource() {
		return pool.getResource();
	}

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
		if (pool != null) {
			pool.destroy();
		}
	}

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

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}
