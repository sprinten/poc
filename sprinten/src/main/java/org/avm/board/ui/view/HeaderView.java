package org.avm.board.ui.view;

import org.avm.vaadin.aspect.theme.Aspect;
import org.avm.vaadin.aspect.widget.RoundedWrapper;



public class HeaderView extends RoundedWrapper {

	private static final long serialVersionUID = -4330380081674808005L;

	public HeaderView() {
		getTitle().addStyleName(Aspect.LABEL_HEADER);
	}
}
