package org.avm.framework.ui.form;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.avm.framework.ui.form.FormLayoutDescriptor.PropertyDescriptor;

public class FormLayoutReader {

	public static final ResourceBundle BUNDLE = ResourceBundle.getBundle("org.avm.framework.ui.form.descriptor");

	private static String getFormKey(String formName) {
		return BUNDLE.getString("form." + formName);
	}

	private static String getFormSize(String formName) {
		String formKey = getFormKey(formName);
		return BUNDLE.getString(formKey + ".size");
	}

	private static Map<Object, PropertyDescriptor> getFormPositions(String formName) {
		Map<Object, PropertyDescriptor> positions = new HashMap<Object, PropertyDescriptor>();
		String formKey = getFormKey(formName);
		String propertyKeyPrefix = formKey + ".property.";

		Enumeration<String> keys = BUNDLE.getKeys();

		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			if (key.startsWith(propertyKeyPrefix)) {

				String replace = key.replace(propertyKeyPrefix, "");
				Object propertyId = replace.split("_")[0];
				PropertyDescriptor position = new PropertyDescriptor(propertyId);

				key = key.replace("_position", "");
				key = key.replace("_size", "");
				String[] values = BUNDLE.getString(key + "_position").split(",");
				try {
					position.setUpLeftCol(Integer.parseInt(values[0]));
					position.setUpLeftRow(Integer.parseInt(values[1]));
					position.setLowRightCol(Integer.parseInt(values[2]));
					position.setLowRightRow(Integer.parseInt(values[3]));
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
				values = BUNDLE.getString(key + "_size").split(",");

				try {
					position.setWidth(Integer.parseInt(values[0]));
					position.setHeight(Integer.parseInt(values[1]));
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}

				positions.put(propertyId, position);
			}
		}
		return positions;

	}

	public static final FormLayoutDescriptor readFormLayoutDescriptor(String formName) {
		FormLayoutDescriptor descriptor = new FormLayoutDescriptor(formName);
		String[] formSizes = getFormSize(formName).split(",");
		descriptor.setCols(Integer.parseInt(formSizes[0]));
		descriptor.setRows(Integer.parseInt(formSizes[1]));
		descriptor.setPositions(getFormPositions(formName));
		return descriptor;
	}
}
