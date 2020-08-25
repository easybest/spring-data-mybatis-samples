package org.springframework.data.mybatis.samples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mybatis.samples.domain.Shop;
import org.springframework.data.mybatis.samples.service.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author JARVIS SONG
 */
@RestController
@RequestMapping("/shop")
public class ShopController extends BasePageableController<ShopService, Shop, Long> {

	@Autowired
	protected ShopController(ShopService service) {
		super(service);
	}

	@Override
	public ResponseEntity<Page<Shop>> page(Pageable pageable, Shop entity) {
		Example<Shop> example = Example.of(entity,
				ExampleMatcher.matching().withMatcher("name", matcher -> matcher.ignoreCase().contains()));
		return new ResponseEntity<>(this.getService().find(example, pageable), HttpStatus.OK);
	}

}
