package org.avm.vaadin.aspect.widget;

import org.apache.log4j.Logger;
import org.avm.vaadin.aspect.widget.color.Color;
import org.avm.vaadin.aspect.widget.color.Colored;
import org.avm.vaadin.aspect.widget.color.Shade;
import org.avm.vaadin.aspect.widget.color.Shaded;

import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.VerticalLayout;

public class ColoredCustomLayout extends CustomLayout implements Colored, Shaded {

	private static final long serialVersionUID = -3826264862172638177L;

	private static final Logger LOGGER = Logger.getLogger(ColoredCustomLayout.class);

	private static final String LOCATION_CONTENT = "content";

	private Color color = Color.UNDEFINED;

	private Shade shade = Shade.UNDEFINED;

	public ColoredCustomLayout() {
		super("colored");
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
			removeStyleName("color" + "-" + this.color);
		}

		// Update color
		this.color = newColor;

		if (!Color.UNDEFINED.equals(this.color)) {
			addStyleName("color" + "-" + this.color);
		}
	}

	public Shade getShade() {
		return shade;
	}

	public void setShade(Shade newShade) {
		if (Color.UNDEFINED.equals(this.color)) {
			// throw new UnsupportedOperationException("Can't have shades whitout colors");
			return;
		}

		if (!Shade.UNDEFINED.equals(this.shade)) {
			removeStyleName("color" + "-" + this.color + "-" + this.shade);
		}

		// Update shade
		this.shade = newShade;

		if (!Shade.UNDEFINED.equals(this.shade)) {
			addStyleName("color" + "-" + this.color + "-" + this.shade);
		} else {
			addStyleName("color" + "-" + this.color);
		}
	}
}
