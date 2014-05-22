package org.avm.sprinten.ui.main;

import org.apache.log4j.Logger;
import org.avm.vaadin.aspect.theme.Aspect;
import org.vaadin.navigator7.NavigableApplication;
import org.vaadin.navigator7.window.NavigableAppLevelWindow;

@SuppressWarnings("serial")
public class MainApplication extends NavigableApplication {

	private static final Logger LOGGER = Logger.getLogger(MainApplication.class);

	public MainApplication() {
		LOGGER.debug("new");
		setTheme(Aspect.themeName());
	}

	@Override
	public NavigableAppLevelWindow createNewNavigableAppLevelWindow() {
		return new MainWindow();
	}
}
