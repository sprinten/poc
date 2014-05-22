package org.avm.sprinten.ui.pages;

import org.avm.vaadin.aspect.widget.ColoredCustomLayout;
import org.avm.vaadin.aspect.widget.HorizontalLine;
import org.avm.vaadin.aspect.widget.color.Color;
import org.avm.vaadin.aspect.widget.color.Shade;
import org.vaadin.navigator7.Page;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

@Page(uriName = "events")
public class EventsPage extends TemporaryPage {

	private static final long serialVersionUID = 8904631057473655624L;

	public EventsPage() {
		super("Color Demo");
		GridLayout newContent = new GridLayout(Shade.values().length, Color.values().length);
		newContent.setMargin(true);
		newContent.setSpacing(true);
		newContent.setWidth("100%");
		setContent(newContent);


		Color[] colors = Color.values();
		Shade[] shades = Shade.values();

		for (int shadeIndex = 0; shadeIndex < shades.length; shadeIndex++) {
			newContent.addComponent(new Label(shades[shadeIndex].toString()));
		}

		for (int colorIndex = 0; colorIndex < colors.length; colorIndex++) {

			for (int shadeIndex = 0; shadeIndex < shades.length; shadeIndex++) {
				newContent.addComponent(new HorizontalLine());
			}

			for (int shadeIndex = 0; shadeIndex < shades.length; shadeIndex++) {

				ColoredCustomLayout colored = new ColoredCustomLayout();
				colored.setWidth("100px");
				colored.setHeight("100px");
				colored.setColor(colors[colorIndex]);
				colored.setShade(shades[shadeIndex]);

				newContent.addComponent(colored);
				newContent.setComponentAlignment(colored, Alignment.MIDDLE_CENTER);
			}
		}

	}
}
