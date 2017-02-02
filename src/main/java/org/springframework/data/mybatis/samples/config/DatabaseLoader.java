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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mybatis.samples.security.*;
//import org.springframework.data.mybatis.samples.security.SiteService;
//import org.springframework.data.mybatis.samples.security.SiteServiceRepository;

@Configuration
public class DatabaseLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);

    private final SiteServiceRepository  siteServiceRepository;
    private final SiteFunctionRepository siteFunctionRepository;
    private final SiteContentRepository  siteContentRepository;

    @Autowired
    public DatabaseLoader(
            SiteServiceRepository siteServiceRepository,
            SiteFunctionRepository siteFunctionRepository,
            SiteContentRepository siteContentRepository
    ) {
        this.siteServiceRepository = siteServiceRepository;
        this.siteFunctionRepository = siteFunctionRepository;
        this.siteContentRepository = siteContentRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        try {


//			siteServiceRepository.save(new SiteService("User service"));
//			siteServiceRepository.save(new SiteService("Reservation service"));

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

        } catch (Exception e) {
            logger.error("Can't load database data because of " + e.getMessage());
            throw e;
        }
    }

}