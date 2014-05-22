package org.avm.sprinten.ui.content;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Navigation {
	private static final String BUNDLE_NAME = "org.avm.sprinten.ui.content.navigation";

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	public static final char URI_SEPARATOR = '/';

	public static final String ALL = "all";

	private Navigation() {
	}

	public static String getText(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static String getText(String key, Object... params) {
		String string = getText(key);
		return MessageFormat.format(string, params);
	}
}

















