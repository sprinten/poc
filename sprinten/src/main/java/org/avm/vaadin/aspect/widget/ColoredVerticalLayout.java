package org.avm.vaadin.aspect.widget;

import org.apache.log4j.Logger;
import org.avm.vaadin.aspect.widget.color.Color;
import org.avm.vaadin.aspect.widget.color.Colored;
import org.avm.vaadin.aspect.widget.color.Shade;
import org.avm.vaadin.aspect.widget.color.Shaded;

import com.vaadin.ui.VerticalLayout;

public class ColoredVerticalLayout extends VerticalLayout implements Colored, Shaded {

	private static final long serialVersionUID = -3826264862172638177L;

	private static final Logger LOGGER = Logger.getLogger(ColoredVerticalLayout.class);

	private Color color = Color.UNDEFINED;

	private Shade shade = Shade.UNDEFINED;

	public ColoredVerticalLayout() {
		super();
		LOGGER.debug("new");
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
			// throw new
			// UnsupportedOperationException("Can't have shades whitout colors");
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
