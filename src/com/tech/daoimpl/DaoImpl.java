package com.tech.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.daoi.DaoI;
import com.tech.model.Customer;

@Repository
public class DaoImpl implements DaoI {
	
	@Autowired
	SessionFactory sf;

	@Override
	public int saveData(Customer cs) {
		
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(cs);
		tx.commit();
		session.close();
		
		return 1;
	}

	@Override
	public List<Customer> getData(String user, String pass) {
		
		Session session=sf.openSession();
		Query q=session.createQuery("from Customer");
		List<Customer> acclist=q.getResultList();
		session.close();
		return acclist;
		
	}

	@Override
	public List<Customer> singleData(String user, String pass) {
		Session session=sf.openSession();
		Query q=session.createQuery("from Customer where userName=:us and password=:pass");
		q.setParameter("us", user);
		q.setParameter("pass", pass);
		List<Customer> list=q.getResultList();
		session.close();
		return list;
	}

	@Override
	public void deleteData(int addharNo) {
		
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Customer cs=session.get(Customer.class, addharNo);
		session.delete(cs);
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Customer> getAllData() {
		Session session=sf.openSession();
		Query q=session.createQuery("from Customer");
		List<Customer>acclist=q.getResultList();
		return acclist;
	}

	@Override
	public Customer editData(int addharNo) {
		Session session=sf.openSession();
		Customer cs=session.get(Customer.class, addharNo);
		session.close();
		return cs;
	}

	@Override
	public Customer depositMoney(int addharNo) {
		Session session=sf.openSession();
		Customer cs=session.get(Customer.class, addharNo);
		session.close();
		return cs;
	}

	@Override
	public Customer updateAmount(Customer cs) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		double d=cs.getTotalAmount();
		Customer c=session.get(Customer.class, cs.getAddharNo());
		if(d>0) {
			
		c.setTotalAmount(d+c.getTotalAmount());
		
		Query q=session.createQuery("update Customer set totalAmount=:am where addharNo=:adhar");
		q.setParameter("am",c.getTotalAmount());
		q.setParameter("adhar", c.getAddharNo());
		q.executeUpdate();
		
		session.saveOrUpdate(c);
		tx.commit();
		session.close();
		
		return c;
		}
		else {
			System.out.println("enter valid amount >=500");
		}
		
		
		return c;
		
	}

	@Override
	public Customer withdrawMoney(int addharNo) {
		Session session=sf.openSession();
		Customer c=session.get(Customer.class, addharNo);
		session.close();
		return c;
	}

	@Override
	public Customer updateWithdraw(Customer c) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		//withdraw amount
		double d=c.getTotalAmount();
		Customer cs=session.get(Customer.class, c.getAddharNo());
		double totalBalance=cs.getTotalAmount()-d;
		if(totalBalance>=500) {
			
			cs.setTotalAmount(totalBalance);
			
			Query q=session.createQuery("update Customer set totalAmount=:am where addharNo=:adhar");
			q.setParameter("am", cs.getTotalAmount());
			q.setParameter("adhar", cs.getAddharNo());
			session.saveOrUpdate(cs);
			tx.commit();
			session.close();
			
			return cs;
		}
		else {
			System.out.println("please check your account balance is less");
		}
		return cs;
	}

}
