package org.avm.sprinten.ui.main.deco;

import org.avm.sprinten.ui.pages.DashboardPage;
import org.avm.sprinten.ui.pages.WelcomePage;
import org.avm.sprinten.ui.pages.WhiteboardPage;
import org.avm.vaadin.aspect.theme.Aspect;
import org.avm.vaadin.aspect.widget.RoundedLayout;
import org.avm.vaadin.aspect.widget.color.Color;
import org.vaadin.navigator7.PageLink;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Link;
import com.vaadin.ui.VerticalLayout;

public class Footer extends RoundedLayout {

	private static final long serialVersionUID = 2517066948248705858L;

	private HorizontalLayout layout = new HorizontalLayout();

	public Footer() {
		super();
		setWidth("100%");
		getLocationContent().setHeight("60px");
		setColor(Color.BLUE);

		((VerticalLayout) getLocationContent()).setSpacing(false);
		((VerticalLayout) getLocationContent()).setMargin(false);

		layout.setSizeFull();
		layout.setSpacing(true);
		layout.setMargin(true);

		addComponent(layout);

		Link label1 = new PageLink("Quick Links", WhiteboardPage.class);
		Link label2 = new PageLink("Fine Print", WhiteboardPage.class);
		Link label3 = new PageLink("Stay In Touch", WelcomePage.class);
		Link label4 = new PageLink("Site Map", DashboardPage.class);

		label1.addStyleName(Aspect.LINK_FOOTER);
		label2.addStyleName(Aspect.LINK_FOOTER);
		label3.addStyleName(Aspect.LINK_FOOTER);
		label4.addStyleName(Aspect.LINK_FOOTER);

		layout.addComponent(label1);
		layout.addComponent(label2);
		layout.addComponent(label3);
		layout.addComponent(label4);

		layout.setComponentAlignment(label1, Alignment.TOP_RIGHT);
		layout.setComponentAlignment(label2, Alignment.TOP_CENTER);
		layout.setComponentAlignment(label3, Alignment.TOP_CENTER);
		layout.setComponentAlignment(label4, Alignment.TOP_LEFT);

		layout.setExpandRatio(label1, 0.25f);
		layout.setExpandRatio(label2, 0.25f);
		layout.setExpandRatio(label3, 0.25f);
		layout.setExpandRatio(label4, 0.25f);
	}
}
