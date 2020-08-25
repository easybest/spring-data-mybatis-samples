package org.springframework.data.mybatis.samples.controller;

import org.springframework.data.mybatis.samples.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseController<S extends BaseService<T, ID>, T, ID> {

	private final S service;

	protected BaseController(S service) {
		this.service = service;
	}

	protected S getService() {
		return service;
	}

	@GetMapping("{id}")
	public ResponseEntity<T> get(@PathVariable("id") ID id) {
		T entity = this.getService().getById(id);
		if (null == entity) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(entity);
	}

	@PostMapping
	public ResponseEntity<T> create(@RequestBody @Validated T entity) {
		return new ResponseEntity<>(this.getService().insertSelective(entity), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<T> modify(@PathVariable("id") ID id, @RequestBody @Validated T entity) {
		return ResponseEntity.ok(this.getService().updateSelective(id, entity));
	}

	@DeleteMapping("{id}")
	public ResponseEntity remove(@PathVariable("id") ID id) {
		this.getService().deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
