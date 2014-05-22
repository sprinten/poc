package org.avm.vaadin.aspect.widget;

import org.avm.vaadin.aspect.theme.Aspect;
import org.avm.vaadin.aspect.widget.color.Color;

import com.vaadin.terminal.Resource;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Link;
import com.vaadin.ui.NativeButton;

public class ColoredLinkButton extends LinkButton {

	private static final long serialVersionUID = 119667998992668794L;

	private Color color = Color.UNDEFINED;

	public ColoredLinkButton() {
		super();
	}

	public ColoredLinkButton(Link link) {
		super(link);
	}

	public ColoredLinkButton(NativeButton button) {
		super(button);
	}

	public ColoredLinkButton(String caption, boolean isLink) {
		super(caption, isLink);
	}

	public ColoredLinkButton(String caption, ClickListener listener) {
		super(caption, listener);
	}

	public ColoredLinkButton(String caption, Object target, String methodName) {
		super(caption, target, methodName);
	}

	public ColoredLinkButton(String caption, Resource resource, String targetName, int width, int height, int border) {
		super(caption, resource, targetName, width, height, border);
	}

	public ColoredLinkButton(String caption, Resource resource) {
		super(caption, resource);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color newColor) {

		if (!Color.UNDEFINED.equals(this.color)) {
			removeStyleName(Aspect.BUTTON_AWESOME + "-" + this.color);
		}

		this.color = newColor;

		if (!Color.UNDEFINED.equals(newColor)) {
			addStyleName(Aspect.BUTTON_AWESOME + "-" + newColor);
		}
	}
}
