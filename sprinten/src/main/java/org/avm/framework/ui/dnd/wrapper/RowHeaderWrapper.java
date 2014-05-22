package org.avm.framework.ui.dnd.wrapper;

import org.avm.board.ui.Whiteboard;
import org.avm.vaadin.aspect.theme.Aspect;
import org.avm.vaadin.aspect.theme.Icons;
import org.avm.vaadin.aspect.widget.IconButton;

import com.vaadin.event.dd.DropHandler;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

public class RowHeaderWrapper extends DropableWrapper {

	private static final long serialVersionUID = 7824613451996972547L;

	private VerticalLayout verLayout = new VerticalLayout();

	private IconButton addRow = new IconButton(Icons.ICON_PLUS_16);

	private IconButton deleteRow = new IconButton(Icons.ICON_MINUS_16);

	private IconButton cleanRow = new IconButton(Icons.ICON_BIN_16);

	private IconButton upRow = new IconButton(Icons.ICON_UP_16);

	private IconButton downRow = new IconButton(Icons.ICON_DOWN_16);

	@SuppressWarnings("serial")
	public RowHeaderWrapper(final int row, boolean left) {
		super();
		getRootLayout().setSizeFull();
		getRootLayout().addStyleName(Aspect.LAYOUT_TOOLBAR);
		getRootLayout().setSpacing(true);

		verLayout.addStyleName(Aspect.LAYOUT_BUTTONS);

		cleanRow.addListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				((Whiteboard) getParent()).cleanRow(row);
			}
		});

		addRow.addListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				((Whiteboard) getParent()).insertRow(row);
			}
		});

		deleteRow.addListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				((Whiteboard) getParent()).removeRow(row);
			}
		});

		upRow.addListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				((Whiteboard) getParent()).moveUpRow(row);
			}
		});

		downRow.addListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				((Whiteboard) getParent()).moveDownRow(row);
			}
		});

		Alignment alignment = left ? Alignment.MIDDLE_RIGHT : Alignment.MIDDLE_LEFT;
		verLayout.addComponent(upRow);
		verLayout.setComponentAlignment(upRow, alignment);
		verLayout.addComponent(addRow);
		verLayout.setComponentAlignment(addRow, alignment);
		verLayout.addComponent(cleanRow);
		verLayout.setComponentAlignment(cleanRow, alignment);
		verLayout.addComponent(deleteRow);
		verLayout.setComponentAlignment(deleteRow, alignment);
		verLayout.addComponent(downRow);
		verLayout.setComponentAlignment(downRow, alignment);

		getRootLayout().addComponent(verLayout);
		getRootLayout().setComponentAlignment(verLayout, Alignment.MIDDLE_CENTER);
	}

	@Override
	public DropHandler getDropHandler() {
		return null;
	}
}
