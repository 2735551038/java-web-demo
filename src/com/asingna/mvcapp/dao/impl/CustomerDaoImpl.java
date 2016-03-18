package com.asingna.mvcapp.dao.impl;

import java.util.List;

import com.asingna.mvcapp.dao.CustomerDao;
import com.asingna.mvcapp.dao.DAO;
import com.asingna.mvcapp.dao.domain.Customer;

public class CustomerDaoImpl extends DAO<Customer> implements CustomerDao {

	@Override
	public List<Customer> getAll() {
		String sql ="select * from customers";
		return getList(sql, null);
	}

	@Override
	public Customer get(Integer id) {
		String sql ="select * from customers where id = ?";
		return get(sql, id);
	}

	@Override
	public void save(Customer customer) {
		String sql = "insert into customers(name,address,phone) values(?,?,?)";
		update(sql, customer.getName(),customer.getAddress(),customer.getPhone());
	}

	@Override
	public void update(Customer customer) {
		String sql = "update customers set name = ?, address = ?, phone = ? where id = ?";
		update(sql, customer.getName(),customer.getAddress(),customer.getPhone(),customer.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from customers where id = ?";
		update(sql, id);		
	}

	@Override
	public long getCountWithName(String name) {
		String sql = "select count(id) from customers where name = ?";
		return getValue(sql, name);
	}

}
