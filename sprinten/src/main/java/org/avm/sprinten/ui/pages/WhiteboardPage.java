package org.avm.sprinten.ui.pages;

import org.avm.board.ui.WhiteboardView;
import org.avm.board.ui.menu.BoardMenu;
import org.vaadin.navigator7.Navigator.NavigationEvent;
import org.vaadin.navigator7.Page;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.VerticalLayout;

@Page(uriName = "whiteboard")
public class WhiteboardPage extends VerticalLayout implements NavigablePage {

	private static final long serialVersionUID = -4956398209011199713L;

	public WhiteboardPage() {

		WhiteboardView whiteboardView = new WhiteboardView();

		addComponent(new BoardMenu(whiteboardView.getBoard()));

		// TODO: Check if this lazy loading can be moved further up to the page;
		// lazy load the page instead of the view

		addComponent(new WhiteboardView());
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

	public void setContent(ComponentContainer component) {
		throw new UnsupportedOperationException("We won't change the content container.");
	}
}
