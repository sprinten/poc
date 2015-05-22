package com.ybroker.endpoint.generic;

import com.ybroker.model.core.base.Resource;

public interface ReadonlyEndpoint<T extends Resource> {

	public abstract javax.ws.rs.core.Response get();

}