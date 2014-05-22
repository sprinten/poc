package org.avm.board.ui.view.form;

import org.avm.common.domain.Task;
import org.avm.framework.ui.LazyBeanItem;
import org.avm.framework.ui.form.ItemForm;
import org.avm.vaadin.aspect.widget.color.Color;

public class TaskForm extends ItemForm<Task> {

	private static final long serialVersionUID = 914299786917466508L;

	public TaskForm(Task task, Color color) {
		super(task, color);
		setItemDataSource(new LazyBeanItem<Task>(task));
	}
}
