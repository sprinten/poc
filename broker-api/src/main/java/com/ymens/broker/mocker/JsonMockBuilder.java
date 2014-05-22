package com.ymens.broker.mocker;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.UUID;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.fluttercode.datafactory.impl.DataFactory;

import com.ymens.broker.api.model.generic.Resource;
import com.ymens.broker.api.model.scim.User;

public class JsonMockBuilder<T extends Resource> {

	private static final Logger LOGGER = Logger.getLogger(JsonMockBuilder.class);

	public T build(Class<T> beanClass) {

		T response = null;
		PropertyDescriptor[] descriptors = null;

		try {
			response = beanClass.getConstructor().newInstance();
			descriptors = Introspector.getBeanInfo(beanClass).getPropertyDescriptors();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | IntrospectionException e) {

			LOGGER.error("Error introspecting beans", e);
			return response;
		}

		DataFactory fakeData = new DataFactory();

		for (PropertyDescriptor descriptor : descriptors) {
			String propertyName = descriptor.getName();

			try {

				if (PropertyUtils.isReadable(fakeData, propertyName)
						&& PropertyUtils.isWriteable(response, propertyName)) {
					Object propertyValue = PropertyUtils.getProperty(fakeData, propertyName);
					LOGGER.info("Fake property " + propertyName + " has value " + propertyValue);
					if (descriptor.getPropertyType() == propertyValue.getClass()) {
						PropertyUtils.setProperty(response, propertyName, propertyValue);
					}
				} else {

					if (descriptor.getPropertyType() == Integer.class) {
						PropertyUtils.setProperty(response, propertyName, fakeData.getNumber());
					} else if (descriptor.getPropertyType() == String.class) {
						if (propertyName.toLowerCase().contains("address")) {
							PropertyUtils.setProperty(response, propertyName, fakeData.getAddress());
						} else if (propertyName.toLowerCase().contains("name")) {
							PropertyUtils.setProperty(response, propertyName, fakeData.getName());
						} else if (propertyName.toLowerCase().contains("url")) {
							PropertyUtils.setProperty(response, propertyName, "http://" + fakeData.getRandomWord()
									+ ".com");
						} else if (propertyName.toLowerCase().contains("locale")) {
							PropertyUtils.setProperty(response, propertyName, Locale.getDefault().toString());
						} else if (propertyName.toLowerCase().contains("id")) {
							PropertyUtils.setProperty(response, propertyName, UUID.randomUUID().toString());
						} else {
							PropertyUtils.setProperty(response, propertyName, fakeData.getRandomText(10));
						}
					} else if (descriptor.getPropertyType() == Boolean.class) {
						PropertyUtils.setProperty(response, propertyName, fakeData.chance(3));
					}
				}
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				LOGGER.error("Error copying properties", e);
			}
		}

		LOGGER.info("Response object: " + response);

		return response;
	}

	public static void main(String[] args) {
		new JsonMockBuilder<User>().build(User.class);
	}

}
