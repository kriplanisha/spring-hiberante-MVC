package DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.customer;

//for dao implementation and checks for unchecked exceptions
@Repository
public class customerDAO_implement implements customerDAO {

//	inject session factory to connect to DB
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	
	public List<customer> getcustomer() 
	{
		
//		get hibernate session
		Session session=sessionFactory.getCurrentSession();
		
//		create query
		Query<customer> query =session.createQuery("from customer order by firstname",customer.class);
		
//		execute query and get result list
		List<customer> custom = query.getResultList();
		
//		return the results
		return custom;
	}
	
	@Override
	public void savecustomer(customer c) 
	{
//		get session and save customer
		Session session=sessionFactory.getCurrentSession();
//		checks whether id is empty, if it is adds the data else update
		session.saveOrUpdate(c);
	}
	
	@Override
	public customer getcustomer(int id) 
	{
//		get hibernate session
		Session session=sessionFactory.getCurrentSession();
		
//		retrieve data from database from primary key
		customer c=session.get(customer.class, id);
		return c;
	}
	
	@Override
	public void deletecustomer(int id) 
	{
//		get hibernate session
		Session session=sessionFactory.getCurrentSession();
		
//		delete object with primary key
		Query query=session.createQuery("delete from customer where id=:customerid");
		query.setParameter("customerid", id);
		query.executeUpdate();
	}

	@Override
	public List<customer> searchcustomer(String theSearchName) 
	{
//		get hibernate session
		Session session=sessionFactory.getCurrentSession();
		Query q=null;

//		search by name if theSearchName is not empty
		if(theSearchName!=null && theSearchName.trim().length()>0)
		{
			
//			search for first or last name without case
			q=session.createQuery("from customer where lower(firstname)like:thename or lower(lastname)like:thename",customer.class);
			q.setParameter("thename", "%" + theSearchName.toLowerCase() + "%");
		}
		else
		{
			
//			thesearchanme empty, return all list
			q=session.createQuery("from customer",customer.class);
		}
		List<customer> customers=q.getResultList();
		
		return customers;
	}
}
