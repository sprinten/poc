package org.avm.vaadin.aspect.widget;

import org.apache.log4j.Logger;
import org.avm.vaadin.aspect.theme.Aspect;
import org.avm.vaadin.aspect.widget.color.Color;

import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.VerticalLayout;

public class RoundedLayout extends CustomLayout {

	private static final long serialVersionUID = -3826264862172638177L;

	private static final Logger LOGGER = Logger.getLogger(RoundedLayout.class);

	private static final String LOCATION_CONTENT = "content";

	private Color color = Color.UNDEFINED;

	public RoundedLayout() {
		super("rounded");
		LOGGER.debug("new");
		ComponentContainer defaultContent = createDefaultContent();
		setContent(defaultContent);
	}

	/**
	 * Returns the content of the custom layout.
	 *
	 * @return
	 */
	public ComponentContainer getLocationContent() {
		return (ComponentContainer) getComponent(LOCATION_CONTENT);
	}

	/**
	 *
	 * Set the content of the custom layout. If null is given as the new content
	 * then a layout is automatically created and set as the content.
	 *
	 * @param content
	 *            The new content
	 */
	public void setContent(ComponentContainer newContent) {
		ComponentContainer content = getLocationContent();

		// If the content is null we create the default content
		if (newContent == null) {
			newContent = createDefaultContent();
		}

		if (newContent == content) {
			// don't set the same content twice
			return;
		}

		// Sets the panel to be parent for the content
		newContent.setParent(this);

		// Sets the new content
		content = newContent;

		super.addComponent(content, LOCATION_CONTENT);
	}

	/*
	 * Create a ComponentContainer which is added by default to the Panel if
	 * user does not specify any content.
	 *
	 * @return
	 */
	private ComponentContainer createDefaultContent() {
		VerticalLayout layout = new VerticalLayout();

		layout.setMargin(true);
		layout.setSpacing(true);

		return layout;
	}

	@Override
	public void addComponent(Component c) {
		getLocationContent().addComponent(c);
	}

	@Override
	public void removeComponent(Component c) {
		getLocationContent().removeComponent(c);
	}

	@Override
	public void addComponent(Component c, String location) {
		if (!LOCATION_CONTENT.equals(location)) {
			throw new UnsupportedOperationException("Location can only be content");
		}
		super.addComponent(c, location);
	}

	@Override
	public void removeComponent(String location) {
		if (!LOCATION_CONTENT.equals(location)) {
			throw new UnsupportedOperationException("Location can only be content");
		}
		super.removeComponent(location);
	}

	@Override
	public Component getComponent(String location) {
		if (!LOCATION_CONTENT.equals(location)) {
			throw new UnsupportedOperationException("Location can only be content");
		}
		return super.getComponent(location);
	}

	@Override
	public void replaceComponent(Component oldComponent, Component newComponent) {
		getLocationContent().replaceComponent(oldComponent, newComponent);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color newColor) {
		if (!Color.UNDEFINED.equals(this.color)) {
			removeStyleName(Aspect.LAYOUT_ROUNDED + "-" + this.color);
		}
		this.color = newColor;
		if (!Color.UNDEFINED.equals(newColor)) {
			addStyleName(Aspect.LAYOUT_ROUNDED + "-" + newColor);
		}
	}
}
