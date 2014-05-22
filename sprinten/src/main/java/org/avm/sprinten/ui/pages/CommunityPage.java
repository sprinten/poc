package org.avm.sprinten.ui.pages;

import org.avm.vaadin.aspect.theme.Aspect;
import org.avm.vaadin.aspect.widget.ColoredButton;
import org.avm.vaadin.aspect.widget.HorizontalLine;
import org.avm.vaadin.aspect.widget.color.Color;
import org.vaadin.navigator7.Page;
import org.vaadin.navigator7.PageLink;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;

@Page(uriName = "community")
public class CommunityPage extends TemporaryPage {

	private static final long serialVersionUID = 8904631057473655624L;

	public CommunityPage() {

		super("Colored Buttons Demo");
		GridLayout newContent = new GridLayout(1, 36);
		newContent.setMargin(true);
		newContent.setSpacing(true);
		newContent.setWidth("100%");
		setContent(newContent);

		Color[] colors = Color.values();

		PageLink colHeader = new PageLink("Buttons", AboutPage.class);
		colHeader.addStyleName(Aspect.LINK_H3);
		newContent.addComponent(colHeader);
		newContent.setComponentAlignment(colHeader, Alignment.MIDDLE_CENTER);

		newContent.addComponent(new HorizontalLine());

		for (int colorIndex = 0; colorIndex < colors.length; colorIndex++) {

			String caption = colors[colorIndex].toString();

			ColoredButton linkButton = new ColoredButton(caption);
			linkButton.setWidth("250px");
			linkButton.setHeight("100px");
			linkButton.setColor(colors[colorIndex]);

			newContent.addComponent(linkButton);
			newContent.setComponentAlignment(linkButton, Alignment.MIDDLE_CENTER);
		}
	}
}
