package com.tech.servicei;

import java.util.List;

import com.tech.model.Customer;

public interface ServiceI {
	
	public int saveData(Customer cs);
	
	public List<Customer> getData(String user,String pass);
	
	public List<Customer> singleData(String user,String pass);
	
	public void deleteData(int addharNo);
	
	public List<Customer> getAllData();
	
	public Customer editData(int addharNo);
	
	public Customer depositMoney(int addharNo);
	
	public Customer updateAmount(Customer cs);
	
	public Customer withdrawMoney(int addharNo);
	
	public Customer updateWithdraw(Customer c);

}
