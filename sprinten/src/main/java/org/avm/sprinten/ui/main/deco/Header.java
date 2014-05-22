package org.avm.sprinten.ui.main.deco;

import org.avm.vaadin.aspect.theme.Aspect;
import org.avm.vaadin.aspect.widget.RoundedLayout;
import org.avm.vaadin.aspect.widget.color.Color;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class Header extends RoundedLayout {

	private static final long serialVersionUID = 82054929671213993L;

	private VerticalLayout layout = new VerticalLayout();

	public Header() {
		super();

		setWidth("100%");
		getLocationContent().setHeight("100px");
		setColor(Color.ORANGE);

		((VerticalLayout) getLocationContent()).setSpacing(false);
		((VerticalLayout) getLocationContent()).setMargin(false);

		layout.setSizeFull();
		layout.setSpacing(false);
		layout.setMargin(false);

		addComponent(layout);

		Label bannerLabel = new Label("Sprinten");
		bannerLabel.addStyleName(Aspect.LABEL_BANNER);
		bannerLabel.setSizeUndefined();

		layout.addComponent(bannerLabel);
		layout.setComponentAlignment(bannerLabel, Alignment.TOP_CENTER);

		Label sloganLabel = new Label("Agile Consulting & Stuff");
		sloganLabel.addStyleName(Aspect.LABEL_SLOGAN);
		sloganLabel.setSizeUndefined();

		layout.addComponent(sloganLabel);
		layout.setComponentAlignment(sloganLabel, Alignment.TOP_CENTER);
	}

}
