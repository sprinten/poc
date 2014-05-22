package org.avm.framework.ui.dnd.wrapper;

import org.avm.board.ui.view.HeaderView;

import com.vaadin.event.dd.DropHandler;

public class ColHeaderWrapper extends DropableWrapper {

	private static final long serialVersionUID = 6401518448238637840L;

	private HeaderView headerView = new HeaderView();

	public ColHeaderWrapper() {
		super();
		getRootLayout().setWidth("100%");
		getRootLayout().setSpacing(true);


		getRootLayout().addComponent(headerView);
	}

	@Override
	public DropHandler getDropHandler() {
		return null;
	}

	public void setTitle(String title) {
		headerView.setTitleText(title);
	}

}
