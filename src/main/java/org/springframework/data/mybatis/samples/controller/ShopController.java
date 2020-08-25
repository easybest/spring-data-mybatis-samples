package org.springframework.data.mybatis.samples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mybatis.samples.domain.Shop;
import org.springframework.data.mybatis.samples.service.ShopService;
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

}
