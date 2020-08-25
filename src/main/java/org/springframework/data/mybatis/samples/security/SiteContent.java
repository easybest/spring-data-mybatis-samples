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

package org.springframework.data.mybatis.samples.security;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "SITE_CONTENT")
@Entity
public class SiteContent extends SiteAccess {

	@OneToOne
	@JoinColumn(name = "SITE_FUNCTION_ID")
	private SiteFunction siteFunction;

	public SiteFunction getSiteFunction() {
		return siteFunction;
	}

	public void setSiteFunction(SiteFunction siteFunction) {
		this.siteFunction = siteFunction;
	}

}
