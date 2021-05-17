package jeff.dbtest.dbservicecustomer.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jeff.dbtest.dbservicecustomer.model.Customer;
import jeff.dbtest.dbservicecustomer.model.CustomerServiceRel;
import jeff.dbtest.dbservicecustomer.model.Service;

@Repository
public class CustomerDao {

	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	public CustomerDao(DataSource ds) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}
	
	
	
	private final String SELECT_CUSTOMER_SERVICE = "select csr.id as id, csr.customer_id, c.name as customer_name, "
			+ "csr.service_id, s.name as service_name, csr.comment  from customer c, service s, customer_service_rel csr "
			+ " where c.id = csr.customer_id and s.id = csr.service_id and c.id=:id";
	
	
	private final String LIST_ALL_CUSTOMER = "select id, name, comment from customer"; 
	
	private final String LIST_ALL_SERVICE_TO_SUBSCRIBE = "select id, name, comment from service where id not in (select service_id from customer_service_rel where customer_id=:customerId)"; 
	
	private final String DEL_CUSTOMER_SERVICE = "delete from customer_service_rel where id=:id";
	
	private final String INS_CUSTOMER_SERVICE = "insert into customer_service_rel(customer_id, service_id, comment) "
			+ "values (:customerId,:serviceId,:comment)";
	
	public List<CustomerServiceRel> selectCustomerService(Integer customerId){
		
		Map<String, Object> paraMap = Collections.singletonMap("id", customerId);
		
		List<CustomerServiceRel> serList = jdbcTemplate
				.query(SELECT_CUSTOMER_SERVICE, paraMap, new BeanPropertyRowMapper<CustomerServiceRel>(CustomerServiceRel.class));
		return serList;
	}
	
	
	public List<Customer> listAllCustomer(){
		List<Customer> serList = jdbcTemplate.query(LIST_ALL_CUSTOMER, new BeanPropertyRowMapper<Customer>(Customer.class));
		return serList;
	}
	
	public List<Service> listServiceToSubcribe(Integer customerId){
		Map<String, Object> paraMap = Collections.singletonMap("customerId", customerId);
		List<Service> serList = jdbcTemplate.query(LIST_ALL_SERVICE_TO_SUBSCRIBE, paraMap, new BeanPropertyRowMapper<Service>(Service.class));
		return serList;
	}
	
	
	public int deleteCustomerService(Integer csId){
		
		Map<String, Object> paraMap = Collections.singletonMap("id", csId);
		
		int result = jdbcTemplate.update(DEL_CUSTOMER_SERVICE, paraMap);
		return result;
	}
	
	
	public int addCustomerService(Integer customerId, Integer serviceId, String comment){
		
		Map<String, Object> paraMap = new HashMap<>();
		paraMap.put("customerId", customerId);
		paraMap.put("serviceId", serviceId);
		paraMap.put("comment", comment);
		int result = jdbcTemplate.update(INS_CUSTOMER_SERVICE, paraMap);
		return result;
	}
	
}
