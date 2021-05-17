package jeff.dbtest.dbservicecustomer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jeff.dbtest.dbservicecustomer.model.Customer;
import jeff.dbtest.dbservicecustomer.model.CustomerServiceRel;
import jeff.dbtest.dbservicecustomer.model.Service;
import jeff.dbtest.dbservicecustomer.service.CustomerService;

@Controller
@RequestMapping
public class CustomerController {
	
	@Autowired
	CustomerService customerSer;
	
	
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("list", "list");
		
		return "hello";
	}
	
	@RequestMapping("/customerList")
	public String listAllCustomer(Model model) {
		List<Customer> customerList = customerSer.listAllCustomer();
		model.addAttribute("list", customerList);
		return "customerList";
	}
	
	@RequestMapping("/cusDetail/{id}")
	public String cusDetail(Model model, @PathVariable("id") Integer id, String name) {
		
		prePareDatailData(model, id, name);
		return "customerDetail";
	}
	
	
	
	@RequestMapping("/delService/{csId}")
	public String delService(Model model, @PathVariable("csId") Integer csId, Integer customerId, String customerName) {
		customerSer.delCustomerService(csId);
		prePareDatailData(model, customerId, customerName);
		return "customerDetail";
	}
	
	
	@RequestMapping("/addService")
	public String addService(Model model,Integer customerId, Integer serviceId, String comment, String customerName) {
		customerSer.addCustomerService(customerId, serviceId, comment);
		prePareDatailData(model, customerId, customerName);
		return "customerDetail";
	}
	
	
	private void prePareDatailData(Model model, Integer customerId, String customerName) {
		List<CustomerServiceRel> customerList = customerSer.selectCustomerService(customerId);
		model.addAttribute("list", customerList);
		model.addAttribute("cusId", customerId);
		model.addAttribute("cusName", customerName);
		
		List<Service> serList = customerSer.listServiceToSubcribe(customerId);
		model.addAttribute("serList", serList);
	}
}
