package org.avm.vaadin.aspect.widget;

import org.avm.vaadin.aspect.theme.Aspect;

import com.vaadin.ui.Label;

public class HorizontalLine extends Label {

	private static final long serialVersionUID = 3138303826770063803L;

	public HorizontalLine() {
		super("<hr/>", Label.CONTENT_XHTML);
		addStyleName(Aspect.LABEL_LINE);
	}

}
