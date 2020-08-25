package org.springframework.data.mybatis.samples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mybatis.samples.domain.Customer;
import org.springframework.data.mybatis.samples.domain.Name;
import org.springframework.data.mybatis.samples.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author JARVIS SONG
 */
@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseListController<CustomerService, Customer, Name> {

	@Autowired
	protected CustomerController(CustomerService service) {
		super(service);
	}

	@GetMapping("get")
	public ResponseEntity<Customer> get(@RequestParam Name id) {
		Customer entity = this.getService().getById(id);
		if (null == entity) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(entity);
	}

}
