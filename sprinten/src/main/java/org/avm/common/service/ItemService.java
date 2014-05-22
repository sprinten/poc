package org.avm.common.service;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.avm.common.domain.Element;

public class ItemService<T extends Element> {

	private static final Logger LOGGER = Logger.getLogger(ItemService.class);

	public void delete(Integer id) {
		LOGGER.debug("delete()");

	}

	public void save(T bean) {
		LOGGER.debug("save()");

	}

	public Collection<T> findAll() {
		LOGGER.debug("findAll()");
		return new ArrayList<T>();
	}

	public T findById(Integer id) {
		LOGGER.debug("findById()");
		return null;
	}

}
