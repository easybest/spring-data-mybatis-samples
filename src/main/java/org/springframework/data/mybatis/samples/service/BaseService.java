package org.springframework.data.mybatis.samples.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface BaseService<T, ID> {

	Page<T> find(Example<T> example, Pageable pageable);

	List<T> find(Example<T> example);

	List<T> find(Example<T> example, Sort sort);

	T getById(ID id);

	void save(T user);

	T insertSelective(T entity);

	T updateSelective(T entity);

	T updateSelective(ID id, T entity);

	void deleteById(ID id);

	<S extends T> T findOne(Example<S> example);

}
