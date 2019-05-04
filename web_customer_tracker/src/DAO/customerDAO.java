package DAO;

import java.util.List;

import entity.customer;

public interface customerDAO 
{
public List<customer> getcustomer();

public void savecustomer(customer c);

public customer getcustomer(int id);

public void deletecustomer(int id);

public List<customer> searchcustomer(String theSearchName);
}
