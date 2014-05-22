package org.avm.board.ui.menu;

import org.avm.board.ui.Whiteboard;
import org.avm.sprinten.ui.menu.MenuTabItem;
import org.avm.vaadin.aspect.theme.Aspect;

import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;

public class BoardMenu extends TabSheet {

	private static final long serialVersionUID = -1277432985615057963L;

	@SuppressWarnings("serial")
	public BoardMenu(Whiteboard whiteboard) {
		super();

		setStyleName(Aspect.TABSHEET_SMALL);

		final Label start = new Label();
		addTab(start, "", null);

		addTab(new MenuTabItem(new AddTaskForm(whiteboard)), "Add Task", null);
		addTab(new MenuTabItem(new AddStoryForm(whiteboard)), "Add Story", null);
		addTab(new MenuTabItem(new AddRowForm(whiteboard)), "Add Row", null);

		addTab(new MenuTabItem(new AddRowForm(whiteboard)), "Tags", null);
		addTab(new MenuTabItem(new AddRowForm(whiteboard)), "Zoom", null);
		addTab(new MenuTabItem(new AddRowForm(whiteboard)), "Burndown", null);

		addTab(new MenuTabItem(new AddRowForm(whiteboard)), "Setup", null);

		final Label end = new Label();
		addTab(end, "", null);

//		setSelectedTab(start);

		addListener(new SelectedTabChangeListener() {

			public void selectedTabChange(SelectedTabChangeEvent event) {

				if (event.getTabSheet().getSelectedTab() != null) {
					MenuTabItem menuTabItem = (MenuTabItem) event.getTabSheet().getSelectedTab();
					getWindow().addWindow(menuTabItem.getPopup());
//					setSelectedTab(start);
				}
			}
		});
	}
}
