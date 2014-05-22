package org.avm.sprinten.ui.pages;

import org.apache.log4j.Logger;
import org.avm.framework.ui.navigation.Navigable;
import org.avm.sprinten.ui.content.Content;
import org.avm.sprinten.ui.content.Navigation;
import org.avm.sprinten.ui.main.MainWindow;
import org.avm.vaadin.aspect.theme.Aspect;
import org.avm.vaadin.aspect.widget.ColoredButton;
import org.avm.vaadin.aspect.widget.color.Color;
import org.vaadin.navigator7.Navigator.NavigationEvent;
import org.vaadin.navigator7.Page;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

@Page(uriName = "welcome")
public class WelcomePage extends Panel implements NavigablePage, Navigable {

	private static final long serialVersionUID = 3730307719398353386L;

	private static final Logger LOGGER = Logger.getLogger(WelcomePage.class);

	@SuppressWarnings("serial")
	public WelcomePage() {
		super("Presentation");
		LOGGER.debug("new");

		CssLayout cssContent = new CssLayout();
		cssContent.setMargin(true);
		cssContent.setWidth("100%");
		setContent(cssContent);

		Label spacer = new Label();
		spacer.setWidth("20px");

		Label horLine = new Label("<hr/>", Label.CONTENT_XHTML);

		// First Row

		HorizontalLayout rowLabels = new HorizontalLayout();
		rowLabels.setSpacing(true);
		rowLabels.setWidth("100%");

		addComponent(rowLabels);

		// Label 1
		Label labelPromote = new Label(Content.getContent("welcome.label.promote"), Label.CONTENT_XHTML);

		rowLabels.addComponent(labelPromote);
		rowLabels.setComponentAlignment(labelPromote, Alignment.TOP_CENTER);
		rowLabels.setExpandRatio(labelPromote, 1);

		// Add Spacer between columns
		rowLabels.addComponent(spacer);

		// Label 2
		Label labelValues = new Label(Content.getContent("welcome.label.values"), Label.CONTENT_XHTML);

		rowLabels.addComponent(labelValues);
		rowLabels.setComponentAlignment(labelValues, Alignment.TOP_CENTER);
		rowLabels.setExpandRatio(labelValues, 1);

		// Add Spacer between columns
		rowLabels.addComponent(spacer);

		// Label 3
		Label labelStrategy = new Label(Content.getContent("welcome.label.strategy"), Label.CONTENT_XHTML);

		rowLabels.addComponent(labelStrategy);
		rowLabels.setComponentAlignment(labelStrategy, Alignment.TOP_CENTER);
		rowLabels.setExpandRatio(labelStrategy, 1);

		// Add a horizontal line between rows

		addComponent(horLine);

		// Second Row

		HorizontalLayout rowButtons = new HorizontalLayout();
		rowButtons.addStyleName(Aspect.LAYOUT_DARKER);
		rowButtons.setSpacing(true);
		rowButtons.setWidth("100%");

		addComponent(rowButtons);

		Label labelAbout = new Label(Content.getContent("welcome.label.about"), Label.CONTENT_XHTML);
		labelAbout.addStyleName(Aspect.LABEL_SMALL);

		rowButtons.addComponent(labelAbout);
		rowButtons.setComponentAlignment(labelAbout, Alignment.MIDDLE_CENTER);
		rowButtons.setExpandRatio(labelAbout, 1);

		// Add Spacer between columns
		rowButtons.addComponent(spacer);

		ColoredButton buttonBoard = new ColoredButton(Content.getContent("welcome.button.board"), new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				navigateTo(Navigation.getText("page.board"));
			}
		});
		buttonBoard.setColor(Color.ORANGE);
		buttonBoard.setWidth("98%");
		buttonBoard.setHeight("40px");

		rowButtons.addComponent(buttonBoard);
		rowButtons.setComponentAlignment(buttonBoard, Alignment.MIDDLE_CENTER);
		rowButtons.setExpandRatio(buttonBoard, 1);

		// Add Spacer between columns
		rowButtons.addComponent(spacer);

		ColoredButton buttonBlog = new ColoredButton(Content.getContent("welcome.button.blog"), new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				navigateTo(Navigation.getText("page.blog"));
			}
		});
		buttonBlog.setColor(Color.ORANGE);
		buttonBlog.setWidth("98%");
		buttonBlog.setHeight("40px");

		rowButtons.addComponent(buttonBlog);
		rowButtons.setComponentAlignment(buttonBlog, Alignment.MIDDLE_CENTER);
		rowButtons.setExpandRatio(buttonBlog, 1);
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

	public void navigateTo(String tabName) {
		((MainWindow) getApplication().getMainWindow()).navigateTo(tabName);
	}

	public void navigateTo(Component pageParam) {
		((MainWindow) getApplication().getMainWindow()).navigateTo(pageParam);
	}
}
