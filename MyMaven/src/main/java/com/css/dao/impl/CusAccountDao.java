package com.css.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.css.domain.User;
@Repository
public class CusAccountDao extends SqlSessionDaoSupport implements com.css.dao.ICusAccountDao{
	
	private static final String NAMESPACE = "com.css.dao.UserMapper.";
	
	@Resource  
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){  
        super.setSqlSessionFactory(sqlSessionFactory);  
    }  
	
	public User queryUserById(Map<String, Object> map) {
		
		return this.getSqlSession().selectOne(NAMESPACE + "selectByPrimaryKey", map);
	}

}
