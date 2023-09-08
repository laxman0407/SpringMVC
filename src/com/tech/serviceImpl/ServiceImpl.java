package com.tech.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.daoi.DaoI;
import com.tech.model.Customer;
import com.tech.servicei.ServiceI;

@Service
public class ServiceImpl implements ServiceI {

	@Autowired
	DaoI di;

	@Override
	public int saveData(Customer cs) {

		return di.saveData(cs);
	}

	@Override
	public List<Customer> getData(String user, String pass) {
		
		return di.getData(user, pass);
	}

	@Override
	public List<Customer> singleData(String user, String pass) {
		
		return di.singleData(user, pass);
	}

	@Override
	public void deleteData(int addharNo) {
		
		di.deleteData(addharNo);
		
	}

	@Override
	public List<Customer> getAllData() {
		
		return di.getAllData();
	}

	@Override
	public Customer editData(int addharNo) {
		
		return di.editData(addharNo);
	}

	@Override
	public Customer depositMoney(int addharNo) {
		
		return di.depositMoney(addharNo);
	}

	@Override
	public Customer updateAmount(Customer cs) {
		
		return di.updateAmount(cs);
	}

	@Override
	public Customer withdrawMoney(int addharNo) {
		
		return di.withdrawMoney(addharNo);
	}

	@Override
	public Customer updateWithdraw(Customer c) {
		
		return di.updateWithdraw(c);
	}

	
	

}
