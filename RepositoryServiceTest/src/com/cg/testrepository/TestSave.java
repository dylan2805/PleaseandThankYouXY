package com.cg.testrepository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.beans.Customer;
import com.cg.beans.Wallet;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.repository.RepositoryImpl;
import com.cg.service.ServiceImpl;

public class TestSave {
	
//	Repository r;
//	Service s;
//	Wallet w;
//	@Before
//	public void init() {
//		r = new Repository();
//		s = new Service();
//	}
//
//	@Test
//	public void savecustomerdata() throws AccountNotFoundException {
//	Customer c = new Customer("samplename", "23456",500.00);
//	Customer c1 = r.save(c);
//	assertTrue(c1.getMobile().equals("23456"));
//	}
//	
//	@Test (expected = AccountNotFoundException.class)
//	public void savecustomernullcus() throws AccountNotFoundException {
//	Customer c1 = r.save(null);
//	assertTrue(c1.getMobile().equals("23456"));
//	}
}
