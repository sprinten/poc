package org.avm.sprinten.ui.pages;

import org.avm.framework.ui.navigation.Navigable;
import org.avm.sprinten.ui.main.MainWindow;
import org.avm.vaadin.aspect.theme.Aspect;
import org.avm.vaadin.aspect.widget.ColoredButton;
import org.avm.vaadin.aspect.widget.ColoredLinkButton;
import org.avm.vaadin.aspect.widget.HorizontalLine;
import org.avm.vaadin.aspect.widget.color.Color;
import org.vaadin.navigator7.Navigator.NavigationEvent;
import org.vaadin.navigator7.Page;
import org.vaadin.navigator7.PageLink;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Panel;

@Page(uriName = "about")
public class AboutPage extends Panel implements NavigablePage, Navigable {

	private static final long serialVersionUID = 8904631057473655624L;

	private static final String[] styles = new String[] { "", Aspect.BUTTON_CAPTION_SMALL, Aspect.BUTTON_CAPTION_MEDIUM, Aspect.BUTTON_CAPTION_LARGE };

	public AboutPage() {
		super("Awesome Style Demo");
		GridLayout newContent = new GridLayout(3, 28);
		newContent.setMargin(true);
		newContent.setSpacing(true);
		newContent.setWidth("100%");
		setContent(newContent);

		PageLink colHeader = new PageLink("Colored", AboutPage.class);
		colHeader.addStyleName(Aspect.LINK_H3);
		newContent.addComponent(colHeader);
		newContent.setComponentAlignment(colHeader, Alignment.MIDDLE_RIGHT);

		colHeader = new PageLink("Buttons", AboutPage.class);
		colHeader.addStyleName(Aspect.LINK_H3);
		newContent.addComponent(colHeader);
		newContent.setComponentAlignment(colHeader, Alignment.MIDDLE_CENTER);

		colHeader = new PageLink("Links", AboutPage.class);
		colHeader.addStyleName(Aspect.LINK_H3);
		newContent.addComponent(colHeader);
		newContent.setComponentAlignment(colHeader, Alignment.MIDDLE_LEFT);

		newContent.addComponent(new HorizontalLine());
		newContent.addComponent(new HorizontalLine());
		newContent.addComponent(new HorizontalLine());

		Color[] colors = Color.values();
		for (int colorIndex = 0; colorIndex < colors.length; colorIndex++) {
			for (int styleIndex = 0; styleIndex < styles.length; styleIndex++) {

				String caption = (colors[colorIndex] + " " + styles[styleIndex]).trim();

				// button
				ColoredButton colored = new ColoredButton(caption);
				colored.setColor(colors[colorIndex]);
				colored.addStyleName(styles[styleIndex]);

				newContent.addComponent(colored);
				newContent.setComponentAlignment(colored, Alignment.MIDDLE_RIGHT);

				// button
				ColoredLinkButton button = new ColoredLinkButton(caption, false);
				button.setColor(colors[colorIndex]);
				button.addStyleName(styles[styleIndex]);

				newContent.addComponent(button);
				newContent.setComponentAlignment(button, Alignment.MIDDLE_CENTER);

				// link
				ColoredLinkButton link = new ColoredLinkButton(caption, true);
				link.setColor(colors[colorIndex]);
				link.addStyleName(styles[styleIndex]);

				newContent.addComponent(link);
				newContent.setComponentAlignment(link, Alignment.MIDDLE_LEFT);
			}

			newContent.addComponent(new HorizontalLine());
			newContent.addComponent(new HorizontalLine());
			newContent.addComponent(new HorizontalLine());
		}
	}

	public void paramChanged(NavigationEvent navigationEvent) {
		// TODO: To Implement
		// Do nothing
	}

	public String extraValidate(String fragment) {
		// TODO: To Implement
		// Do nothing
		return null;
	}

	public void navigateTo(String tabName) {
		((MainWindow) getApplication().getMainWindow()).navigateTo(tabName);
	}

	public void navigateTo(Component pageParam) {
		((MainWindow) getApplication().getMainWindow()).navigateTo(pageParam);
	}
}
