package com.ybroker.provider;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Catches SaxParseExceptions when unparseable xml input is provided.
 *
 */
@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

	@Override
	public Response toResponse(WebApplicationException exception) {
		exception.printStackTrace();
		if (exception.getCause() != null
				&& exception.getCause().getCause() instanceof org.xml.sax.SAXParseException) {
			return RestException.constructErrorResponse(
					Response.Status.BAD_REQUEST, "input:invalid", RestException.BAD_REQUEST);
		}
		return exception.getResponse();
	}
}