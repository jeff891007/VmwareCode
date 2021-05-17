package jeff.dbtest.dbservicecustomer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeff.dbtest.dbservicecustomer.dao.CustomerDao;
import jeff.dbtest.dbservicecustomer.model.Customer;
import jeff.dbtest.dbservicecustomer.model.CustomerServiceRel;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao cusDao;
	
	@Override
	public List<Customer> listAllCustomer() {
		
		return cusDao.listAllCustomer();
	}

	@Override
	public List<CustomerServiceRel> selectCustomerService(Integer customerId) {
		
		return cusDao.selectCustomerService(customerId);
	}

	@Override
	public int delCustomerService(Integer csId) {
		return cusDao.deleteCustomerService(csId);
	}

	@Override
	public int addCustomerService(Integer customerId, Integer serviceId, String comment) {
		return cusDao.addCustomerService(customerId, serviceId, comment);
	}

	@Override
	public List<jeff.dbtest.dbservicecustomer.model.Service> listServiceToSubcribe(Integer customerId) {
		return cusDao.listServiceToSubcribe(customerId);
	}

}
