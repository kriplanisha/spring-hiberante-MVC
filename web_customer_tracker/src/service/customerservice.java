package service;

import java.util.List;

import entity.customer;

public interface customerservice 
{
public List<customer> getcustomers();

public void savecustomer(customer c);

public customer getcustomer(int id);

public void deletecustomer(int id);

public List<customer> searchcustomers(String theSearchName);
}
