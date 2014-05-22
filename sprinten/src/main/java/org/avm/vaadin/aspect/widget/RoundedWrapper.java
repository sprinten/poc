package org.avm.vaadin.aspect.widget;

import org.apache.log4j.Logger;

public class RoundedWrapper extends RoundedLayout {

	private static final long serialVersionUID = -3826264862172638177L;

	private static final Logger LOGGER = Logger.getLogger(RoundedWrapper.class);

	private EditableLabel title;

	public RoundedWrapper() {
		LOGGER.debug("new");
		title = new EditableLabel("");
		addComponent(title);
	}

	public void setTitleText(String text) {
		title.setValue(text);
	}

	public EditableLabel getTitle() {
		return title;
	}
}
