/*
 *
 *   Copyright 2017 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package org.springframework.data.mybatis.samples.config;

import java.util.Arrays;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mybatis.samples.domain.Address;
import org.springframework.data.mybatis.samples.domain.Shop;
import org.springframework.data.mybatis.samples.repository.ShopRepository;
import org.springframework.data.mybatis.samples.security.SiteContent;
import org.springframework.data.mybatis.samples.security.SiteContentRepository;
import org.springframework.data.mybatis.samples.security.SiteFunction;
import org.springframework.data.mybatis.samples.security.SiteFunctionRepository;
import org.springframework.data.mybatis.samples.security.SiteService;
import org.springframework.data.mybatis.samples.security.SiteServiceRepository;

@Configuration
public class DatabaseLoader implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);

	private final SiteServiceRepository siteServiceRepository;

	private final SiteFunctionRepository siteFunctionRepository;

	private final SiteContentRepository siteContentRepository;

	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	public DatabaseLoader(SiteServiceRepository siteServiceRepository, SiteFunctionRepository siteFunctionRepository,
			SiteContentRepository siteContentRepository) {
		this.siteServiceRepository = siteServiceRepository;
		this.siteFunctionRepository = siteFunctionRepository;
		this.siteContentRepository = siteContentRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		try {

			SiteService userManagementService = new SiteService();
			userManagementService.setName("User management");
			this.siteServiceRepository.save(userManagementService);

			SiteFunction userManagerFunction = new SiteFunction();
			userManagerFunction.setName("User management");
			userManagerFunction.setSiteService(userManagementService);

			SiteContent viewManagerContent = new SiteContent();
			viewManagerContent.setName("view");
			viewManagerContent.setSiteFunction(userManagerFunction);

			this.siteServiceRepository.save(userManagementService);
			this.siteFunctionRepository.save(userManagerFunction);
			this.siteContentRepository.save(viewManagerContent);

			this.shopRepository
					.saveAll(
							Arrays.asList(
									new Shop("Walmart", "shop@walmart.com").setActive(true).setDuration(9)
											.setIntroduce("I am the 300th shop of Walmart.")
											.setAddress(new Address("USA", "NY", "Queen", "351"))
											.setBrandEstablishmentTime(new Calendar.Builder().setDate(1962, 1, 1)
													.build().getTime().getTime())
											.setOpeningTime(
													new Calendar.Builder().setDate(2010, 10, 1).build().getTime()),
									new Shop("Costco", "costco@gmail.com").setActive(false).setDuration(9)
											.setIntroduce("I am the 20th shop of Costco.")
											.setAddress(new Address("USA", "WA", "Issaquah", "908"))
											.setBrandEstablishmentTime(new Calendar.Builder()
													.setDate(1976, 1, 1).build().getTime().getTime())
											.setOpeningTime(
													new Calendar.Builder().setDate(2009, 5, 15).build().getTime()),
									new Shop("Carrefour", "carrefour@gmail.com").setActive(true).setDuration(12)
											.setAddress(new Address("FR", "Boulogne", "Golden", "18"))
											.setBrandEstablishmentTime(new Calendar.Builder()
													.setDate(1959, 1, 1).build().getTime().getTime())
											.setOpeningTime(
													new Calendar.Builder().setDate(2011, 6, 25).build().getTime()),
									new Shop("Auchan", "shop@auchan.com").setActive(true).setDuration(11)
											.setAddress(new Address("FR", "London", "Oushang", "93"))
											.setBrandEstablishmentTime(new Calendar.Builder().setDate(1961, 1, 1)
													.build().getTime().getTime())
											.setOpeningTime(
													new Calendar.Builder().setDate(2010, 3, 15).build().getTime())));

		}
		catch (Exception e) {
			logger.error("Can't load database data because of " + e.getMessage());
			throw e;
		}
	}

}
