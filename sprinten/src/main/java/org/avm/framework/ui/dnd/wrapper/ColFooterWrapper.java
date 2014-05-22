package org.avm.framework.ui.dnd.wrapper;

import org.avm.board.ui.Whiteboard;
import org.avm.vaadin.aspect.theme.Aspect;
import org.avm.vaadin.aspect.theme.Icons;
import org.avm.vaadin.aspect.widget.IconButton;

import com.vaadin.event.dd.DropHandler;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;

public class ColFooterWrapper extends DropableWrapper {

	private static final long serialVersionUID = 7824613451996972547L;

	private HorizontalLayout horLayout = new HorizontalLayout();
	private IconButton cleanCol = new IconButton(Icons.ICON_BIN_16);
	private IconButton leftCol = new IconButton(Icons.ICON_LEFT_16);
	private IconButton rifthCol = new IconButton(Icons.ICON_RIGHT_16);

	@SuppressWarnings("serial")
	public ColFooterWrapper(final int column) {
		super();
		getRootLayout().setWidth("100%");
		getRootLayout().addStyleName(Aspect.LAYOUT_TOOLBAR);
		getRootLayout().setSpacing(true);
		getRootLayout().setHeight("30px");

		horLayout.addStyleName(Aspect.LAYOUT_BUTTONS);

		cleanCol.addListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				((Whiteboard) getParent()).cleanColumn(column);
			}
		});

		leftCol.addListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				((Whiteboard) getParent()).moveCellsLeft(column);
			}
		});

		rifthCol.addListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				((Whiteboard) getParent()).moveCellsRight(column);
			}
		});

		horLayout.addComponent(leftCol);
		horLayout.setComponentAlignment(leftCol, Alignment.TOP_CENTER);

		horLayout.addComponent(cleanCol);
		horLayout.setComponentAlignment(cleanCol, Alignment.TOP_CENTER);

		horLayout.addComponent(rifthCol);
		horLayout.setComponentAlignment(rifthCol, Alignment.TOP_CENTER);

		getRootLayout().addComponent(horLayout);
		getRootLayout().setComponentAlignment(horLayout, Alignment.TOP_CENTER);
	}

	@Override
	public DropHandler getDropHandler() {
		return null;
	}
}
