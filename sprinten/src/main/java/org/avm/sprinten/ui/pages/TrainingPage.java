package org.avm.sprinten.ui.pages;

import org.avm.framework.ui.DateTimeField;
import org.avm.framework.ui.dnd.wrapper.CellWrapper;
import org.avm.vaadin.aspect.theme.Aspect;
import org.avm.vaadin.aspect.widget.ColoredButton;
import org.avm.vaadin.aspect.widget.ColoredLinkButton;
import org.avm.vaadin.aspect.widget.RoundedLayout;
import org.avm.vaadin.aspect.widget.color.Color;
import org.vaadin.navigator7.Page;
import org.vaadin.tokenfield.TokenField;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Field;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Link;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@Page(uriName = "training")
public class TrainingPage extends TemporaryPage {

	private static final long serialVersionUID = 8904631057473655624L;

	public TrainingPage() {

		super("Demo Page for Styles");
		GridLayout newContent = new GridLayout(5, 5);
		newContent.setMargin(true);
		newContent.setSpacing(true);
		newContent.setSizeFull();
		setContent(newContent);

		// Form
		Field field = new TextField("Text Field Item Form");
		field.addStyleName(Aspect.ITEM_FORM);
		newContent.addComponent(field);
		newContent.setComponentAlignment(field, Alignment.MIDDLE_CENTER);

		field = new TokenField("Token Field Item Form");
		field.addStyleName(Aspect.ITEM_FORM);
		newContent.addComponent(field);
		newContent.setComponentAlignment(field, Alignment.MIDDLE_CENTER);

		field = new TextArea("Text Area Item Form");
		field.addStyleName(Aspect.ITEM_FORM);
		newContent.addComponent(field);
		newContent.setComponentAlignment(field, Alignment.MIDDLE_CENTER);

		field = new DateTimeField("Date Time Field Item Form");
		field.addStyleName(Aspect.ITEM_FORM);
		newContent.addComponent(field);
		newContent.setComponentAlignment(field, Alignment.MIDDLE_CENTER);

		field = new ListSelect("List Select Item Form");
		field.addStyleName(Aspect.ITEM_FORM);
		newContent.addComponent(field);
		newContent.setComponentAlignment(field, Alignment.MIDDLE_CENTER);

		// Labels
		Label label = new Label("Label Slogan");
		label.addStyleName(Aspect.LABEL_SLOGAN);
		newContent.addComponent(label);
		newContent.setComponentAlignment(label, Alignment.MIDDLE_CENTER);

		label = new Label("Label Post Content");
		label.addStyleName(Aspect.LABEL_POST);
		newContent.addComponent(label);
		newContent.setComponentAlignment(label, Alignment.MIDDLE_CENTER);

		label = new Label("Label Tag");
		label.addStyleName(Aspect.LABEL_TAG);
		newContent.addComponent(label);
		newContent.setComponentAlignment(label, Alignment.MIDDLE_CENTER);

		label = new Label("Label Title");
		label.addStyleName(Aspect.LABEL_TITLE);
		newContent.addComponent(label);
		newContent.setComponentAlignment(label, Alignment.MIDDLE_CENTER);

		label = new Label("Label Banner");
		label.addStyleName(Aspect.LABEL_BANNER);
		newContent.addComponent(label);
		newContent.setComponentAlignment(label, Alignment.MIDDLE_CENTER);

		// Layout

		Layout layout = new VerticalLayout();
		layout.setCaption("Layout Rounded");
		layout.addStyleName(Aspect.LAYOUT_ROUNDED);
		newContent.addComponent(layout);
		newContent.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);

		layout = new VerticalLayout();
		layout.setCaption("Layout Light Orange");
		layout.addStyleName(Aspect.LAYOUT_BLUE_LIGHTEST);
		newContent.addComponent(layout);
		newContent.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);

		layout = new VerticalLayout();
		layout.setCaption("Layout Toolbar");
		layout.addStyleName(Aspect.LAYOUT_TOOLBAR);
		newContent.addComponent(layout);
		newContent.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);

		layout = new VerticalLayout();
		layout.setCaption("Layout Darker");
		layout.addStyleName(Aspect.LAYOUT_DARKER);
		newContent.addComponent(layout);
		newContent.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);

		layout = new VerticalLayout();
		layout.setCaption("Layout Item Form");
		layout.addStyleName(Aspect.LAYOUT_ITEMFORM);
		newContent.addComponent(layout);
		newContent.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);

		// Link

		Link link = new Link("Link H1", new ExternalResource("http://www.google.com/h1"));
		link.addStyleName(Aspect.LINK_H1);
		newContent.addComponent(link);
		newContent.setComponentAlignment(link, Alignment.MIDDLE_CENTER);

		link = new Link("Link H2", new ExternalResource("http://www.google.com/h2"));
		link.addStyleName(Aspect.LINK_H2);
		newContent.addComponent(link);
		newContent.setComponentAlignment(link, Alignment.MIDDLE_CENTER);

		link = new Link("Link H3", new ExternalResource("http://www.google.com/h3"));
		link.addStyleName(Aspect.LINK_H3);
		newContent.addComponent(link);
		newContent.setComponentAlignment(link, Alignment.MIDDLE_CENTER);

		link = new Link("Link Strong", new ExternalResource("http://www.google.com/strong"));
		link.addStyleName(Aspect.LINK_STRONG);
		newContent.addComponent(link);
		newContent.setComponentAlignment(link, Alignment.MIDDLE_CENTER);

		link = new Link("Link Footer", new ExternalResource("http://www.google.com/footer"));
		link.addStyleName(Aspect.LINK_FOOTER);
		newContent.addComponent(link);
		newContent.setComponentAlignment(link, Alignment.MIDDLE_CENTER);

		// Widgets

		ColoredButton cButton = new ColoredButton("Colored Button Large");
		cButton.setColor(Color.RED);
		cButton.addStyleName(Aspect.BUTTON_CAPTION_LARGE);
		newContent.addComponent(cButton);
		newContent.setComponentAlignment(cButton, Alignment.MIDDLE_CENTER);

		ColoredLinkButton lButton = new ColoredLinkButton("Link Button Large", false);
		lButton.setColor(Color.BLUE);
		lButton.addStyleName(Aspect.BUTTON_CAPTION_LARGE);
		newContent.addComponent(lButton);
		newContent.setComponentAlignment(lButton, Alignment.MIDDLE_CENTER);

		lButton = new ColoredLinkButton("Link Button Large", true);
		lButton.setColor(Color.GREEN);
		lButton.addStyleName(Aspect.BUTTON_CAPTION_LARGE);
		newContent.addComponent(lButton);
		newContent.setComponentAlignment(lButton, Alignment.MIDDLE_CENTER);

		RoundedLayout rounded = new RoundedLayout();
		rounded.setColor(Color.BROWN);
		newContent.addComponent(rounded);
		newContent.setComponentAlignment(rounded, Alignment.MIDDLE_CENTER);

		CellWrapper wrapper = new CellWrapper();
		newContent.addComponent(wrapper);
		newContent.setComponentAlignment(wrapper, Alignment.MIDDLE_CENTER);
	}

}
