package org.avm.framework.ui.navigation;

import com.vaadin.ui.Component;

public interface Navigable {

	void navigateTo(String tabName);

	void navigateTo(Component page);

}