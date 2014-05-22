package com.ymens.broker.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ymens.broker.api.model.generic.Error;
import com.ymens.broker.api.model.generic.Response;

import javax.xml.datatype.XMLGregorianCalendar;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.module.SimpleModule;

public class SCIMSimpleModule {

	private SimpleModule module;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	SCIMSimpleModule() {

		module = new SimpleModule("SCIM", new Version(1, 0, 0, null)).addSerializer(XMLGregorianCalendar.class,
				new JsonSerializer<XMLGregorianCalendar>() {

					@Override
					public void serialize(XMLGregorianCalendar calendar, JsonGenerator jsonGenerator,
							SerializerProvider provider) throws IOException, JsonProcessingException {
						jsonGenerator.writeString(calendar.toString());
					}
				}).addSerializer(Response.class, new JsonSerializer<Response>() {

			@Override
			public void serialize(Response response, JsonGenerator jsonGenerator, SerializerProvider provider)
					throws IOException, JsonProcessingException {

				List<Error> errors = response.getErrors();
				if (errors != null) {
					jsonGenerator.writeStartObject();
					jsonGenerator.writeFieldName("Errors");
					jsonGenerator.writeStartArray();
					for (Error error : errors) {
						jsonGenerator.writeObject(error);
					}

					jsonGenerator.writeEndArray();
					jsonGenerator.writeEndObject();

				} else if (response.getResource() != null) {
					List<String> schemas = new ArrayList<>();
					schemas.add("urn:scim:schemas:core:1.0");
					schemas.add("urn:scim:schemas:extension:enterprise:1.0");
					response.getResource().setSchemas(schemas);
					jsonGenerator.writeObject(response.getResource());

				} else if (response.getResources() != null) {
					jsonGenerator.writeObject(response.getResources());
				}
			}
		});
	}

	public SimpleModule getModule() {
		return module;
	}
}
