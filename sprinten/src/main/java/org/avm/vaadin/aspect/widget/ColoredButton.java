package org.avm.vaadin.aspect.widget;

import org.avm.vaadin.aspect.widget.color.Color;

import com.vaadin.ui.NativeButton;

public class ColoredButton extends NativeButton {

	private static final long serialVersionUID = 2155574743495395287L;

	private Color color = Color.UNDEFINED;

	public ColoredButton() {
	}

	public ColoredButton(String caption, ClickListener listener) {
		super(caption, listener);
	}

	public ColoredButton(String caption) {
		super(caption);
	}

	public void setColor(Color newColor) {

		if (!Color.UNDEFINED.equals(this.color)) {
			removeStyleName(this.color.toString());
		}

		this.color = newColor;

		if (!Color.UNDEFINED.equals(newColor)) {
			addStyleName(newColor.toString());
		}
	}
}
