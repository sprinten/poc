package org.avm.vaadin.aspect.widget;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Label;

public class IconedLabel extends Label {

	private static final long serialVersionUID = 3095345610143044955L;

	public IconedLabel(String iconPath, String labelText) {
		setValue(labelText);
		ThemeResource icon = new ThemeResource(iconPath);
		setIcon(icon);
	}

}
