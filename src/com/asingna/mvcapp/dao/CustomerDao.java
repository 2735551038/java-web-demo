package com.asingna.mvcapp.dao;

import java.util.List;

import com.asingna.mvcapp.dao.domain.Customer;

public interface CustomerDao {
	public List<Customer> getAll();
	
	public Customer get(Integer id);
	
	public void save(Customer customer);
	
	public void update(Customer customer);
	
	public void delete(Integer id);
	
	public long getCountWithName(String name); 
}
