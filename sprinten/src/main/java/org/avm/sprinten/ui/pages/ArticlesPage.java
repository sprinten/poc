package org.avm.sprinten.ui.pages;

import org.avm.framework.ui.navigation.Navigable;
import org.avm.sprinten.ui.main.MainWindow;
import org.avm.vaadin.aspect.widget.HorizontalLine;
import org.avm.vaadin.aspect.widget.RoundedLayout;
import org.avm.vaadin.aspect.widget.color.Color;
import org.vaadin.navigator7.Navigator.NavigationEvent;
import org.vaadin.navigator7.Page;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

@Page(uriName = "articles")
public class ArticlesPage extends Panel implements NavigablePage, Navigable {

	private static final long serialVersionUID = 8904631057473655624L;

	private static final String[] widths = new String[] { "80px", "180px", "280px" };

	private static final String[] heights = new String[] { "50px", "100px", "200px" };

	public ArticlesPage() {
		super("Round Layouts Demo");
		GridLayout newContent = new GridLayout(3, 30);
		newContent.setMargin(true);
		newContent.setSpacing(true);
		newContent.setWidth("100%");
		setContent(newContent);

		newContent.addComponent(new HorizontalLine());
		newContent.addComponent(new HorizontalLine());
		newContent.addComponent(new HorizontalLine());
		newContent.addComponent(new HorizontalLine());
		newContent.addComponent(new HorizontalLine());
		newContent.addComponent(new HorizontalLine());

		for (int heightIndex = 0; heightIndex < heights.length; heightIndex++) {

			Color[] colors = Color.values();
			for (int colorIndex = 0; colorIndex < colors.length; colorIndex++) {
				for (int widthIndex = 0; widthIndex < widths.length; widthIndex++) {

					String caption = (colors[colorIndex] + " " + widths[widthIndex] + " " + heights[heightIndex]).trim();

					RoundedLayout rounded = new RoundedLayout();
					rounded.setColor(colors[colorIndex]);

					rounded.setWidth(widths[widthIndex]);
					rounded.getLocationContent().setHeight(heights[heightIndex]);

					rounded.addComponent(new Label("rounded: " + caption));

					newContent.addComponent(rounded);
					newContent.setComponentAlignment(rounded, Alignment.MIDDLE_CENTER);
				}
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
