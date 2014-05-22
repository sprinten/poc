package org.avm.board.ui.view;

import org.avm.vaadin.aspect.theme.Aspect;
import org.avm.vaadin.aspect.widget.RoundedWrapper;


public class EmptyItemView extends RoundedWrapper {

	private static final long serialVersionUID = 2317562440832744639L;

	public EmptyItemView() {
		super();
		setWidth("95%");
		setTitleText("");
		getTitle().addStyleName(Aspect.LABEL_EMPTY);
		// This should be the minimum height of a card; HACK
		// getTitleLabel().setHeight("50px");
	}

}
