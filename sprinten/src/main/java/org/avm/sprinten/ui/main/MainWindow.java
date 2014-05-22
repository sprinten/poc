package org.avm.sprinten.ui.main;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.avm.framework.ui.navigation.Navigable;
import org.avm.sprinten.ui.main.deco.Footer;
import org.avm.sprinten.ui.main.deco.Header;
import org.vaadin.navigator7.Navigator;
import org.vaadin.navigator7.interceptor.ExceptionPage;
import org.vaadin.navigator7.window.HeaderFooterFixedAppLevelWindow;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

public class MainWindow extends HeaderFooterFixedAppLevelWindow implements Navigable {

	public static final int DEFAULT_PAGE_WIDTH = 1100;

	private static final long serialVersionUID = 1296821771756655632L;

	private static final Logger LOGGER = Logger.getLogger(MainWindow.class);

	private MainMenu mainMenu = new MainMenu();
	private Header mainHeader = new Header();
	private Footer mainFooter = new Footer();

	@Override
	public void attach() {
		// Main layout creation.
		// Do that before you add anything to the Window.
		Layout main = createMainLayout();
		this.setContent(main);

		// Must be done after calling this.setConent(main)
		// as for any component added to the window.
		this.navigator = new Navigator();
		this.addComponent(navigator);

		// Let descendants add components in this.getContent().
		pageContainer = createComponents();
	}

	@Override
	protected Component createHeader() {
		VerticalLayout vLayout = new VerticalLayout();
		vLayout.addComponent(mainHeader);
		vLayout.setComponentAlignment(mainHeader, Alignment.TOP_CENTER);
		vLayout.addComponent(mainMenu);
		vLayout.setComponentAlignment(mainMenu, Alignment.MIDDLE_CENTER);
		return vLayout;
	}

	@Override
	protected Component createFooter() {
		VerticalLayout vLayout = new VerticalLayout();
		vLayout.addComponent(mainFooter);
		vLayout.setComponentAlignment(mainFooter, Alignment.BOTTOM_CENTER);
		return vLayout;
	}

	@Override
	protected ComponentContainer createComponents() {
		setPageWidth(DEFAULT_PAGE_WIDTH);

		VerticalLayout windowContentLayout = (VerticalLayout) this.getContent();

		// Header
		header = createHeader();
		headerBand = createBandLayout(header);
		windowContentLayout.addComponent(headerBand);
		windowContentLayout.setComponentAlignment(headerBand, Alignment.TOP_CENTER);

		// Center page area
		Layout pageBand = createBandLayout(null);
		windowContentLayout.addComponent(pageBand);
		windowContentLayout.setComponentAlignment(pageBand, Alignment.MIDDLE_CENTER);

		// Footer
		footer = createFooter();
		footerBand = createBandLayout(footer);
		windowContentLayout.addComponent(footerBand);
		windowContentLayout.setComponentAlignment(footerBand, Alignment.BOTTOM_CENTER);

		return pageBand;
	}

	/**
	 * Create a layout around the given component, and prepare the component to
	 * have a fixed width inside the band
	 */
	@Override
	protected Layout createBandLayout(Component innerComponent) {
		HorizontalLayout result = new HorizontalLayout();
		if (innerComponent != null) {
			prepareInnerBand(innerComponent);
			result.addComponent(innerComponent);
			result.setComponentAlignment(innerComponent, Alignment.MIDDLE_CENTER);
		}
		return result;
	}

	@Override
	protected void prepareInnerBand(Component innerComponent) {
		innerComponent.setWidth(getPageWidth(), Component.UNITS_PIXELS);
	}

	@Override
	protected Layout createMainLayout() {
		VerticalLayout verDashLayout = new VerticalLayout();
		verDashLayout.setMargin(true);
		return verDashLayout;
	}

	/**
	 * Sets the page in the window, at the right place (and removes the previous
	 * one) Override this (don't forget to call super) if you want to do
	 * something everytime a new page is being placed
	 */
	@Override
	synchronized public void changePage(Component pageParam) {

		LOGGER.info("[changePage()]");
		if (!(pageParam instanceof ExceptionPage)) {
			navigateTo(pageParam);
		}

		internalChangePage(pageParam);
		prepareInnerBand(page);
	}

	/*
	 * Copied from NavigableAppLevelWindow
	 *
	 * @param pageParam
	 */
	private void internalChangePage(Component pageParam) {
		pageContainer.removeAllComponents();
		this.page = pageParam;
		pageContainer.addComponent(page);
	}

	public void navigateTo(Component pageParam) {
		mainMenu.navigateTo(pageParam);
	}

	public void navigateTo(String tabName) {
		mainMenu.navigateTo(tabName);
	}

	public static void printParentInfo(Component parent) {
		if (parent == null) {
			LOGGER.info("[parents]:[no more parents]");
			return;
		} else {
			LOGGER.info("[parents]:[" + parent.getClass() + "][" + parent.getHeight() + "]");
			printParentInfo(parent.getParent());
		}
	}

	public static void printChildInfo(Component child) {
		if (child == null) {
			LOGGER.info("[child]:[no more children]");
			return;
		} else	if (!(child instanceof ComponentContainer)) {
				LOGGER.info("[child]:[not a container]");
				return;

		} else {
			LOGGER.info("[child]:[" + child.getClass() + "][" + child.getHeight() + "]");
			ComponentContainer container = (ComponentContainer) child;
			for (Iterator<Component> iterator = container.getComponentIterator(); iterator.hasNext();) {
				printChildInfo(iterator.next());
			}
		}
	}
}
