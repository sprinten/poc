package org.avm.sprinten.ui.pages;

import org.apache.log4j.Logger;
import org.avm.framework.ui.navigation.Navigable;
import org.avm.sprinten.ui.main.MainWindow;
import org.avm.vaadin.aspect.theme.Aspect;
import org.avm.vaadin.aspect.theme.Icons;
import org.avm.vaadin.aspect.widget.ColoredButton;
import org.avm.vaadin.aspect.widget.HorizontalLine;
import org.avm.vaadin.aspect.widget.IconButton;
import org.avm.vaadin.aspect.widget.color.Color;
import org.vaadin.navigator7.Navigator.NavigationEvent;
import org.vaadin.navigator7.PageLink;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class TemporaryPage extends Panel implements NavigablePage, Navigable {

	private static final long serialVersionUID = 3730307719398353386L;

	private static final Logger LOGGER = Logger.getLogger(TemporaryPage.class);

	@SuppressWarnings("serial")
	public TemporaryPage(String caption) {
		super(caption);
		LOGGER.debug("new");

		VerticalLayout verContent = new VerticalLayout();
		verContent.setMargin(true);
		verContent.setWidth("100%");
		setContent(verContent);

		Label spacer = new Label();
		spacer.setWidth("20px");

		GridLayout grid = new GridLayout(3, 3);
		grid.setSpacing(true);
		grid.setMargin(true);
		grid.setColumnExpandRatio(0, 1.f);
		grid.setColumnExpandRatio(1, 1.f);
		grid.setColumnExpandRatio(2, 1.f);
		grid.setRowExpandRatio(0, 1.f);
		grid.setRowExpandRatio(1, 1.f);
		grid.setRowExpandRatio(2, 1.f);

		verContent.addComponent(grid);
		verContent.setComponentAlignment(grid, Alignment.MIDDLE_CENTER);

		// Spacers

		grid.addComponent(new Label(), 1, 0);
		grid.addComponent(new Label(), 1, 1);
		grid.addComponent(new Label(), 1, 2);
		grid.addComponent(new Label(), 0, 1);
		grid.addComponent(new Label(), 2, 1);

		PageLink linkInfo1 = new PageLink("This page is under construction.", WelcomePage.class);
		linkInfo1.addStyleName(Aspect.LINK_H1);

		PageLink linkInfo2 = new PageLink("Please do come back soon!", WelcomePage.class);
		linkInfo2.addStyleName(Aspect.LINK_H1);

		IconButton tool1 = new IconButton(Icons.ICON_BLOG_TOOL_48);
		IconButton tool2 = new IconButton(Icons.ICON_BLOG_TOOL2_48);

		grid.addComponent(tool1, 0, 0);
		grid.setComponentAlignment(tool1, Alignment.MIDDLE_CENTER);

		grid.addComponent(tool2, 0, 2);
		grid.setComponentAlignment(tool1, Alignment.MIDDLE_CENTER);

		grid.addComponent(linkInfo1, 2, 0);
		grid.setComponentAlignment(linkInfo1, Alignment.MIDDLE_LEFT);

		grid.addComponent(linkInfo2, 2, 2);
		grid.setComponentAlignment(linkInfo2, Alignment.MIDDLE_LEFT);

		// Add a horizontal line between rows

		verContent.addComponent(new HorizontalLine());

		// Second Row

		HorizontalLayout linkRow = new HorizontalLayout();
		linkRow.addStyleName(Aspect.LAYOUT_DARKER);
		linkRow.setSpacing(true);
		linkRow.setWidth("100%");

		verContent.addComponent(linkRow);

		Label labelAbout = new Label("<h4>About This Site</h4> This is a work in progress and under construction. Please be patient and do come back!",
				Label.CONTENT_XHTML);
		labelAbout.addStyleName(Aspect.LABEL_SMALL);

		linkRow.addComponent(labelAbout);
		linkRow.setComponentAlignment(labelAbout, Alignment.MIDDLE_CENTER);
		linkRow.setExpandRatio(labelAbout, 1);

		// Add Spacer between columns
		linkRow.addComponent(spacer);

		ColoredButton buttonBoard = new ColoredButton("View Whiteboard >>", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				navigateTo("Whiteboard");
			}
		});
		buttonBoard.setColor(Color.ORANGE);
		buttonBoard.setWidth("98%");
		buttonBoard.setHeight("40px");

		linkRow.addComponent(buttonBoard);
		linkRow.setComponentAlignment(buttonBoard, Alignment.MIDDLE_CENTER);
		linkRow.setExpandRatio(buttonBoard, 1);

		// Add Spacer between columns
		linkRow.addComponent(spacer);

		ColoredButton buttonBlog = new ColoredButton("Visit Blog >>", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				navigateTo("Blog");
			}
		});
		buttonBlog.setColor(Color.ORANGE);
		buttonBlog.setWidth("98%");
		buttonBlog.setHeight("40px");

		linkRow.addComponent(buttonBlog);
		linkRow.setComponentAlignment(buttonBlog, Alignment.MIDDLE_CENTER);
		linkRow.setExpandRatio(buttonBlog, 1);
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
