package com.ymens.broker.api.endpoint.generic;

import com.ymens.broker.api.model.generic.Resource;

public interface ReadonlyEndpoint<T extends Resource> {

	public abstract javax.ws.rs.core.Response get();

}