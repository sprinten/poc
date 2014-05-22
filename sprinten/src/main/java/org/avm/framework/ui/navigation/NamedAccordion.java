package org.avm.framework.ui.navigation;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vaadin.terminal.Resource;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Component;

public class NamedAccordion extends Accordion implements NamedSheet  {

	private static final long serialVersionUID = 3784928600206893947L;

	private static final Logger LOGGER = Logger.getLogger(NamedAccordion.class);

	private Map<String, Component> tabComponentMap = new HashMap<String, Component>();

	private Map<Component, String> componentNameMap = new HashMap<Component, String>();

	public NamedAccordion() {
		super();
	}

	@Override
	public void addComponent(Component c) {
		throw new UnsupportedOperationException("Only named components can be added.");
	}

	@Override
	public Tab addTab(Component c, String tabCaption, Resource icon) {
		return super.addTab(c, tabCaption, icon);
	}

	@Override
	public Tab addTab(Component c, String caption, Resource icon, int position) {
		tabComponentMap.put(caption, c);
		componentNameMap.put(c, caption);
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

	/* (non-Javadoc)
	 * @see org.avm.framework.ui.navigation.NamedSheet#getTab(java.lang.String)
	 */
	public Component getTab(String tabCaption) {
		return tabComponentMap.get(tabCaption);
	}

	/* (non-Javadoc)
	 * @see org.avm.framework.ui.navigation.NamedSheet#getTabName(com.vaadin.ui.Component)
	 */
	public String getTabName(Component tab) {
		return componentNameMap.get(tab);
	}

	public void setSelectedTab(String tabCaption) {
		LOGGER.info("[Selected Tab][" + tabCaption + "]");
		Component tab = getTab(tabCaption);
		LOGGER.info("[Selected Component][" + tab + "]");
		super.setSelectedTab(tab);
	}
}