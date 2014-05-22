package org.avm.framework.ui.navigation;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.avm.sprinten.ui.main.MainApplication;
import org.avm.sprinten.ui.main.MainWindow;
import org.vaadin.navigator7.Navigator;
import org.vaadin.navigator7.NavigatorConfig;

import com.vaadin.terminal.Resource;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

public class NavigableTabSheet extends NamedTabSheet implements Navigable {

	private static final long serialVersionUID = 4577523633629020717L;

	private static final Logger LOGGER = Logger.getLogger(NavigableTabSheet.class);

	private Map<String, Component> pageMap = new HashMap<String, Component>();

	public NavigableTabSheet() {
		super();
		LOGGER.debug("new");
	}

	/**
	 * @param page
	 * @param pageName
	 * @return
	 */
	public void addPage(Component page, String pageName) {
		MockTab mockTab = new MockTab();
		mockTab.setHeight("0px");
		mockTab.setVisible(false);
		super.addTab(mockTab, pageName, null);

		pageMap.put(pageName.toLowerCase(), page);
	}

	@Override
	public void addComponent(Component c) {
		throw new UnsupportedOperationException("Only method allowed: addTab(Component page, String pageName)");
	}

	@Override
	public Tab addTab(Component c, String caption, Resource icon) {
		throw new UnsupportedOperationException("Only method allowed: addTab(Component page, String pageName)");
	}

	@Override
	public Tab addTab(Component comp, String caption, Resource icon, int position) {
		if (!(comp instanceof MockTab)) {
			throw new UnsupportedOperationException("Only method allowed: addTab(Component page, String pageName)");
		}
		return super.addTab(comp, caption, icon, position);
	}

	@Override
	public Tab addTab(Component c) {
		throw new UnsupportedOperationException("Only method allowed: addTab(Component page, String pageName)");
	}

	@Override
	public Tab addTab(Component c, int position) {
		throw new UnsupportedOperationException("Only method allowed: addTab(Component page, String pageName)");
	}

	public Component getPage(String pageName) {
		return pageMap.get(pageName.toLowerCase());
	}

	/* (non-Javadoc)
	 * @see org.avm.framework.ui.navigation.Navigable#navigateTo(java.lang.String)
	 */
	public void navigateTo(String tabName) {

		LOGGER.info("[tabName=" + tabName + "]");
		Component tabComponent = getTab(tabName);

		LOGGER.info("[tabComponent=" + tabComponent + "]");

		internalNavigateTo(tabComponent, true);
	}

	/* (non-Javadoc)
	 * @see org.avm.framework.ui.navigation.Navigable#navigateTo(com.vaadin.ui.Component)
	 */
	public void navigateTo(Component page) {
		NavigatorConfig navigatorConfig = ((MainApplication) getApplication()).getWebApplication().getNavigatorConfig();
		Class<? extends Component> pageClass = page.getClass();

		LOGGER.info("[pageClass=" + pageClass + "]");
		String pageName = navigatorConfig.getPageName(pageClass);

		LOGGER.info("[tabName=" + pageName + "]");
		Component tabComponent = getTab(pageName);

		LOGGER.info("[tabComponent=" + tabComponent + "]");

		internalNavigateTo(tabComponent, false);
	}

	@Override
	public void setSelectedTab(Component mockTab) {
		internalNavigateTo(mockTab, true);
	}

	private void internalNavigateTo(Component mockTab, boolean fromTab) {
		super.setSelectedTab(mockTab);

		String pageName = getTabName(mockTab);
		LOGGER.info("[pageName=" + pageName + "]");


		getApplication().getMainWindow().showNotification("Page Changed: " + pageName);

		if (fromTab) {
			Navigator navigator = ((MainWindow) getApplication().getMainWindow()).getNavigator();
			Class<? extends Component> pageClass = getPage(pageName).getClass();
			LOGGER.info("[pageClass=" + pageClass + "]");

			navigator.navigateTo(pageClass);
		}
	}

	@SuppressWarnings("serial")
	public class MockTab extends HorizontalLayout {
	}
}
