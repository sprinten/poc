package org.avm.sprinten.ui.pages;

import org.avm.sprinten.ui.content.Navigation;
import org.vaadin.navigator7.Navigator.NavigationEvent;
import org.vaadin.navigator7.Page;

import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@Page(uriName = "dashboard")
public class DashboardPage extends Panel implements NavigablePage {

	private static final long serialVersionUID = -9160929210188221854L;

	public DashboardPage() {
		setCaption(Navigation.getText("page.admin.caption"));
		VerticalLayout newContent = new VerticalLayout();
		setContent(newContent);
//		newContent.setSpacing(true);
		newContent.setMargin(true);
		newContent.setSizeFull();
	}

	public void paramChanged(NavigationEvent navigationEvent) {
		// TODO: To Implement
		// DO nothing
	}

	public String extraValidate(String fragment) {
		// TODO: To Implement
		// DO nothing
		return null;
	}
}
