package org.avm.framework.ui.navigation;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vaadin.terminal.Resource;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

public class NamedTabSheet extends TabSheet implements NamedSheet {

	private static final long serialVersionUID = 3784928600206893947L;

	private static final Logger LOGGER = Logger.getLogger(NamedTabSheet.class);

	private Map<String, Component> tabComponentMap = new HashMap<String, Component>();

	private Map<Component, String> componentNameMap = new HashMap<Component, String>();

	public NamedTabSheet() {
		super();
	}

	@Override
	public void addComponent(Component c) {
		throw new UnsupportedOperationException("Only named components can be added.");
	}

	@Override
	public Tab addTab(Component c, String caption, Resource icon) {
		return super.addTab(c, caption, icon);
	}

	@Override
	public Tab addTab(Component c, String caption, Resource icon, int position) {
		tabComponentMap.put(caption.toLowerCase(), c);
		componentNameMap.put(c, caption.toLowerCase());
		return super.addTab(c, caption, icon, position);
	}

	@Override
	public Tab addTab(Component c) {
		throw new UnsupportedOperationException("Only named components can be added.");
	}

	@Override
	public Tab addTab(Component c, int position) {
		throw new UnsupportedOperationException("Only named components can be added.");
	}

	public Component getTab(String tabCaption) {
		return tabComponentMap.get(tabCaption.toLowerCase());
	}

	public String getTabName(Component tab) {
		return componentNameMap.get(tab).toLowerCase();
	}

	public void setSelectedTab(String tabCaption) {
		LOGGER.info("[Selected Tab][" + tabCaption + "]");
		Component tab = getTab(tabCaption);
		LOGGER.info("[Selected Component][" + tab + "]");
		super.setSelectedTab(tab);
	}

}