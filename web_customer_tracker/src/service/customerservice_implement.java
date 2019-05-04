package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.customerDAO;
import entity.customer;

@Service
public class customerservice_implement implements customerservice {

//	need to inject customer dao
	@Autowired
	private customerDAO custom;
	
	@Override
	@Transactional
	public List<customer> getcustomers() 
	{
		return custom.getcustomer();
	}

	@Override
	@Transactional
	public void savecustomer(customer c) 
	{
		custom.savecustomer(c);
	}

	@Override
	@Transactional
	public customer getcustomer(int id) 
	{
		return custom.getcustomer(id);
	}

	@Override
	@Transactional
	public void deletecustomer(int id) 
	{
		custom.deletecustomer(id);
	}

	@Override
	@Transactional
	public List<customer> searchcustomers(String theSearchName) 
	{
		return custom.searchcustomer(theSearchName);
	}

}
