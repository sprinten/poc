package org.avm.sprinten.ui.content;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Content {
	private static final String BUNDLE_NAME = "org.avm.sprinten.ui.content.content";

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Content() {
	}

	public static String getContent(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static String getContent(String key, Object... params) {
		String string = getContent(key);
		return MessageFormat.format(string, params);
	}
}

















