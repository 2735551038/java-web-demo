package com.asingna.mvcapp.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.asingna.mvcapp.dao.db.JdbcUtil;


public class DAO<T> {
	
	private QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> clazz; 
	
	public DAO() {
		Type superClass = getClass().getGenericSuperclass();
		
		if(superClass instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType) superClass;
			Type[] typeArg = parameterizedType.getActualTypeArguments();
			if(typeArg != null && typeArg.length>0){
				if(typeArg[0] instanceof Class){
					clazz = (Class<T>) typeArg[0];
				}
			}
		}
	}
	
	public List<T> getList(String sql, Object ...args){
		Connection connection = null;
		try {
			connection = JdbcUtil.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.releaseConnection(connection);
		}
		
		return null;
	}
	
	public T get(String sql, Object ...args){
		Connection connection = null;
		try {
			connection = JdbcUtil.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.releaseConnection(connection);
		}
		
		return null;
	}
	
	public <E> E getValue(String sql, Object ...args){
		Connection connection = null;
		try {
			connection = JdbcUtil.getConnection();
			return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.releaseConnection(connection);
		} 
		
		return null;
	}
	
	public void update(String sql, Object ...args) {
		Connection connection = null;
		try {
			connection = JdbcUtil.getConnection();
			 
			queryRunner.update(connection, sql, args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.releaseConnection(connection);
		}
	}
}
