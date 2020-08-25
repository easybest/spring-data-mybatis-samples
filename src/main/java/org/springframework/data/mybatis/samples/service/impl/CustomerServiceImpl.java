package org.springframework.data.mybatis.samples.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mybatis.samples.domain.Customer;
import org.springframework.data.mybatis.samples.domain.Name;
import org.springframework.data.mybatis.samples.repository.CustomerRepository;
import org.springframework.data.mybatis.samples.service.CustomerService;
import org.springframework.data.mybatis.samples.service.DefaultBaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * .
 *
 * @author JARVIS SONG
 */
@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl extends DefaultBaseService<CustomerRepository, Customer, Name>
		implements CustomerService {

	@Autowired
	protected CustomerServiceImpl(CustomerRepository repository) {
		super(repository);
	}

}
