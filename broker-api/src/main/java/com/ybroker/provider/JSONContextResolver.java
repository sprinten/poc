package com.ybroker.provider;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializationProblemHandler;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JSONContextResolver implements ContextResolver<ObjectMapper>, MessageBodyWriter<Object>, MessageBodyReader<Object> {

//	private static final String CORE = "urn:scim:schemas:core:1.0";
	private static final String ENTERPRISE = "urn:scim:schemas:extension:enterprise:1.0";

	private ObjectMapper objectMapper;

	public JSONContextResolver() {
		objectMapper = new ObjectMapper();

		DeserializationConfig deserializationConfig = objectMapper.getDeserializationConfig();
		deserializationConfig.addHandler(new JsonDeserializationProblemHandler());

		objectMapper.setDeserializationConfig(deserializationConfig);
		objectMapper.setSerializationConfig(
				objectMapper.getSerializationConfig().with(Feature.INDENT_OUTPUT)
						.withSerializationInclusion(JsonSerialize.Inclusion.NON_NULL)
						.withSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY));
		SCIMSimpleModule moduleLocal = new SCIMSimpleModule();
		objectMapper.registerModule(moduleLocal.getModule());
	}

	@Override
	public ObjectMapper getContext(Class<?> objectType) {
		return objectMapper;
	}

	@Override
	public long getSize(Object target, Class<?> clazz, Type type, Annotation[] annotation, MediaType mediaType) {
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> clazz, Type type, Annotation[] annotation, MediaType mediaType) {
		return mediaType.isCompatible(MediaType.APPLICATION_JSON_TYPE);
	}

	@Override
	public void writeTo(Object target, Class<?> clazz, Type type, Annotation[] annotation, MediaType mediaType,
			MultivaluedMap<String, Object> map, OutputStream outputStream) throws IOException, WebApplicationException {
		objectMapper.writeValue(outputStream, target);
	}

	@Override
	public boolean isReadable(Class<?> clazz, Type type, Annotation[] annotation, MediaType mediaType) {
		return isWriteable(clazz, type, annotation, mediaType);
	}

	@Override
	public Object readFrom(Class<Object> clazz, Type type, Annotation[] annotation, MediaType mediaType,
			MultivaluedMap<String, String> map, InputStream inputStream) throws IOException, WebApplicationException {
		try {
			return objectMapper.readValue(inputStream, clazz);

		} catch (org.codehaus.jackson.JsonParseException | java.io.EOFException e) {
			throw new RestException(Status.BAD_REQUEST, "input:invalid", RestException.BAD_REQUEST);

		} catch (org.codehaus.jackson.map.exc.UnrecognizedPropertyException e) {
			throw new RestException(Status.BAD_REQUEST,
					"input:invalid", RestException.BAD_REQUEST + ": " + e.getUnrecognizedPropertyName());

		} catch (org.codehaus.jackson.map.JsonMappingException e) {
			throw new RestException(Status.BAD_REQUEST, e.getPath().isEmpty()
					? "input:invalid" : e.getPath().get(0).getFieldName() + ":invalid");
		}
	}

	private class JsonDeserializationProblemHandler extends DeserializationProblemHandler {

		@Override
		public boolean handleUnknownProperty(DeserializationContext ctx, JsonDeserializer<?> deserializer,
				Object beanOrClass, String propertyName) throws IOException, JsonProcessingException {
			return ENTERPRISE.equals(propertyName);
		}
	}
}