package org.avm.vaadin.aspect.widget;

import org.avm.vaadin.aspect.theme.Aspect;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;

public class IconButton extends Button {

	private static final long serialVersionUID = -6307234253528112349L;

	public IconButton(String iconPath) {
		super();
		addStyleName(Aspect.BUTTON_LINK);
		addStyleName(Aspect.BUTTON_ICON);
		ThemeResource icon = new ThemeResource(iconPath);
		setIcon(icon);
	}

}
