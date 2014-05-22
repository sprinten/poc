package org.avm.framework.ui.navigation;

import com.vaadin.ui.HorizontalLayout;

public class InvisibleContainer extends HorizontalLayout {

	private static final long serialVersionUID = -3303994242548581835L;

	private Object data;

	public InvisibleContainer() {
		super();
		setWidth("0px");
		setHeight("0px");
		setVisible(true);
	}

	public InvisibleContainer(Object data) {
		this();
		this.data = data;
	}

	public Object getData() {
		return data;
	}
}
