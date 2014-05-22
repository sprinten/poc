package org.avm.sprinten.ui.menu;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Form;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class PopupWindow extends Window {

	private static final long serialVersionUID = 7142024459577889316L;

	private VerticalLayout layout = new VerticalLayout();

	public PopupWindow(Form form) {

		setCaption(form.getCaption());

		setModal(true);
		setDraggable(false);
		setResizable(false);

		setWidth("350px");

		layout.setMargin(true);
		layout.setSizeFull();

		setContent(layout);

		layout.addComponent(form);
		layout.setComponentAlignment(form, Alignment.MIDDLE_CENTER);
	}

	public void exit() {
		close();
	}
}
