package org.avm.board.ui.menu;

import org.avm.board.ui.Whiteboard;
import org.avm.board.ui.view.TaskView;
import org.avm.common.domain.Task;
import org.avm.sprinten.ui.content.Navigation;
import org.avm.sprinten.ui.menu.PopupWindow;

import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.ui.Button.ClickEvent;

public class AddTaskForm extends ConfigurationForm {

	private static final long serialVersionUID = 4165065192676778813L;

	private PropertysetItem item = new PropertysetItem();

	public AddTaskForm(Whiteboard whiteboard) {
		super(whiteboard);

		setCaption(Navigation.getText("page.board.form.add.task"));
		// Some data to bind the form to
		item.addItemProperty("rowIndex", new ObjectProperty<Integer>(0));
		item.addItemProperty("colIndex", new ObjectProperty<Integer>(0));

		setItemDataSource(item);

		setVisibleItemProperties(new Object[] { "colIndex" , "rowIndex" });
	}

	public void buttonClick(ClickEvent event) {
		Integer row = Integer.valueOf(item.getItemProperty("rowIndex").getValue().toString());
		Integer col = Integer.valueOf(item.getItemProperty("colIndex").getValue().toString());
		getBoard().addItemView(new TaskView(new Task()), col, row);
		((PopupWindow)getParent().getParent()).exit();
	}
}
