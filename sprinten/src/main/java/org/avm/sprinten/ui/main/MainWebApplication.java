package org.avm.sprinten.ui.main;

import org.avm.sprinten.ui.pages.AboutPage;
import org.avm.sprinten.ui.pages.ArticlesPage;
import org.avm.sprinten.ui.pages.CommunityPage;
import org.avm.sprinten.ui.pages.DashboardPage;
import org.avm.sprinten.ui.pages.EventsPage;
import org.avm.sprinten.ui.pages.TrainingPage;
import org.avm.sprinten.ui.pages.WelcomePage;
import org.avm.sprinten.ui.pages.WhiteboardPage;
import org.avm.sprinten.ui.test.RunoPage;
import org.vaadin.navigator7.WebApplication;
import org.vaadin.navigator7.interceptor.NavigationWarningInterceptor;
import org.vaadin.navigator7.interceptor.PageChangeListenersInterceptor;

public class MainWebApplication extends WebApplication {

	private PageChangeListenersInterceptor pageChangeListenerInterceptor;

	public MainWebApplication() {
		registerPages(new Class[] { WelcomePage.class, WhiteboardPage.class, DashboardPage.class, AboutPage.class, ArticlesPage.class,
				EventsPage.class, TrainingPage.class, CommunityPage.class, RunoPage.class,});
	}

	@Override
	protected void registerInterceptors() {
		// 1st interceptor to call: check if user really wanna quit.
		registerInterceptor(new NavigationWarningInterceptor());
		registerInterceptor(pageChangeListenerInterceptor = new PageChangeListenersInterceptor());

		// Default interceptors.
		super.registerInterceptors();
	}

	public PageChangeListenersInterceptor getPageChangeListenerInterceptor() {
		return pageChangeListenerInterceptor;
	}
}
