package org.avm.framework.ui.navigation;

import com.vaadin.ui.Component;

public interface NamedSheet {

	Component getTab(String tabCaption);

	String getTabName(Component tab);

	void setSelectedTab(String tabCaption);

}