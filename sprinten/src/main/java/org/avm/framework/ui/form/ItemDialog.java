package org.avm.framework.ui.form;

import org.avm.common.domain.BacklogItem;
import org.avm.vaadin.aspect.widget.color.Color;

import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class ItemDialog<T extends BacklogItem> extends Window {

	private static final long serialVersionUID = -4376918352773919298L;

	private final VerticalLayout layout = new VerticalLayout();

	public ItemDialog(T element) {
		setModal(true);
		setDraggable(false);
		setResizable(false);

		setWidth("540px");
		// setHeight("480px");

		layout.setMargin(true);
		layout.setSizeFull();
		setContent(layout);


		setCaption(element.getName());
	}

	public VerticalLayout getRootLayout() {
		return layout;
	}

	public void setColor(Color newColor) {
		// TODO Auto-generated method stub

	}

}
