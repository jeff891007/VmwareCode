package jeff.dbtest.dbservicecustomer.service;

import java.util.List;

import jeff.dbtest.dbservicecustomer.model.Customer;
import jeff.dbtest.dbservicecustomer.model.CustomerServiceRel;
import jeff.dbtest.dbservicecustomer.model.Service;

public interface CustomerService {
	
	public List<Customer> listAllCustomer();
	public List<Service> listServiceToSubcribe(Integer customerId);
	
	public List<CustomerServiceRel> selectCustomerService(Integer customerId);
	
	public int delCustomerService(Integer csId);
	
	public int addCustomerService(Integer customerId, Integer serviceId, String comment);

}
