package com.asingna.mvcapp.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.asingna.mvcapp.dao.CustomerDao;
import com.asingna.mvcapp.dao.domain.Customer;
import com.asingna.mvcapp.dao.impl.CustomerDaoImpl;

public class CustomerDaoImplTest {

	private CustomerDao customerDao = new CustomerDaoImpl();
	
	@Test
	public void testGetAll() { 
		List<Customer> cList =  customerDao.getAll();
		System.out.println(cList);
	}

	@Test
	public void testGetInteger() {
		Customer customer = customerDao.get(1);
		System.out.println(customer);
	}

	@Test
	public void testSave() { 
//		Customer customer = new Customer("Mike", "SH", "136612312");
//		customerDao.save(customer);
	}

	@Test
	public void testUpdateCustomer() { 
	}

	@Test
	public void testDelete() { 
		customerDao.delete(1);
	}

	@Test
	public void testGetCountWithName() { 
	}

}
