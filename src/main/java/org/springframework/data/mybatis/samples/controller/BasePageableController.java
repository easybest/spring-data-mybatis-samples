/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.mybatis.samples.controller;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mybatis.samples.service.BaseService;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * .
 *
 * @author JARVIS SONG
 */
public abstract class BasePageableController<S extends BaseService<T, ID>, T, ID> extends BaseController<S, T, ID> {

	protected BasePageableController(S service) {
		super(service);
	}

	@GetMapping
	public ResponseEntity<Page<T>> page(@PageableDefault(20) Pageable pageable, T entity) {
		Example<T> example = Example.of(entity, ExampleMatcher.matching());
		return new ResponseEntity<>(this.getService().find(example, pageable), HttpStatus.OK);
	}

}
