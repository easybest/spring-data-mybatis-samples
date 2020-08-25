package org.springframework.data.mybatis.samples.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mybatis.samples.domain.Shop;
import org.springframework.data.mybatis.samples.repository.ShopRepository;
import org.springframework.data.mybatis.samples.service.DefaultBaseService;
import org.springframework.data.mybatis.samples.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * .
 *
 * @author JARVIS SONG
 */
@Service
@Transactional(readOnly = true)
public class ShopServiceImpl extends DefaultBaseService<ShopRepository, Shop, Long> implements ShopService {

	@Autowired
	protected ShopServiceImpl(ShopRepository repository) {
		super(repository);
	}

}
