package org.avm.sprinten.ui.main;

import org.apache.log4j.Logger;
import org.avm.framework.ui.navigation.Navigable;
import org.avm.framework.ui.navigation.NavigableTabSheet;
import org.avm.sprinten.ui.content.Navigation;
import org.avm.sprinten.ui.pages.AboutPage;
import org.avm.sprinten.ui.pages.ArticlesPage;
import org.avm.sprinten.ui.pages.CommunityPage;
import org.avm.sprinten.ui.pages.DashboardPage;
import org.avm.sprinten.ui.pages.EventsPage;
import org.avm.sprinten.ui.pages.TrainingPage;
import org.avm.sprinten.ui.pages.WelcomePage;
import org.avm.sprinten.ui.pages.WhiteboardPage;
import org.avm.sprinten.ui.test.RunoPage;

import com.vaadin.ui.TabSheet.SelectedTabChangeListener;

public class MainMenu extends NavigableTabSheet implements Navigable, SelectedTabChangeListener {

	private static final long serialVersionUID = -1277432985615057963L;

	private static final Logger LOGGER = Logger.getLogger(MainMenu.class);

	public MainMenu() {
		super();
		LOGGER.debug("NEW");

		addPage(new WelcomePage(), Navigation.getText("page.welcome"));

		// TODO: Replace Mock Pages

		addPage(new AboutPage(), Navigation.getText("page.about"));
		addPage(new ArticlesPage(), Navigation.getText("page.articles"));
		addPage(new TrainingPage(), Navigation.getText("page.training"));
		addPage(new EventsPage(), Navigation.getText("page.events"));
		addPage(new CommunityPage(), Navigation.getText("page.community"));
		addPage(new RunoPage(), Navigation.getText("page.demo"));

		addPage(new WhiteboardPage(), Navigation.getText("page.board"));

		addPage(new DashboardPage(), Navigation.getText("page.admin"));

		addListener(this);
	}

	public void selectedTabChange(SelectedTabChangeEvent event) {
		LOGGER.info("[Tab Changed]");
		// TODO:
		// Component selectedTab = event.getTabSheet().getSelectedTab();
	}
}
