package org.avm.sprinten.ui.menu;

import com.vaadin.ui.Form;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class MenuTabItem extends VerticalLayout {

	private static final long serialVersionUID = -5272019339656073619L;

	private Window popup;

	public MenuTabItem(Form form) {
		super();
		popup = new PopupWindow(form);
	}

	public Window getPopup() {
		return popup;
	}
}
