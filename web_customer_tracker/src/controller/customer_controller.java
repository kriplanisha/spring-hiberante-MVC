package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DAO.customerDAO;
import entity.customer;
import service.customerservice;

@Controller
@RequestMapping("/customer")
public class customer_controller 
{
//	need to inject customer service
	@Autowired
	private customerservice custom;
	@RequestMapping("/list")
	public String listcustomer(Model themodel)
	{
//		get customers from customer service
		List<customer> cust = custom.getcustomers();
		
//		add customer to the model
		themodel.addAttribute("customers",cust);
		
		return "list-customers";
	}
	
	@GetMapping("/showform")
	public String showform(Model themodel)
	{
//		create model attribute to bind the data
		customer c= new customer();
		themodel.addAttribute("customer",c);
		return "customer-form";
	}
	
	@PostMapping("/savecustomer")
	public String savecustomer(@ModelAttribute("customer") customer c)
	{
//		saving customer using service
		custom.savecustomer(c);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showformforupdate")
	public String updatecustomer(@RequestParam("customerid") int id, Model themodel)
	{
//		get customer from database
		customer c= custom.getcustomer(id);
		
//		set customer as model attribute to prepopulate the form
		themodel.addAttribute("customer",c);
		
//		send to form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deletecustomer(@RequestParam("customerid") int id)
	{
//		delete the customer
		custom.deletecustomer(id);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchcustomer(@RequestParam("theSearchName") String theSearchName, Model themodel)
	{
//		search customer from list
		List<customer> customers=custom.searchcustomers(theSearchName);
		
//		add customers to model
		themodel.addAttribute("customers",customers);
		return "list-customers";
	}
}
