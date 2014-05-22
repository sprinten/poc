package org.avm.board.ui.view;

import org.avm.board.ui.view.dialog.TaskDialog;
import org.avm.common.domain.Task;

public class TaskView extends AbstractItemView<Task> {

	private static final long serialVersionUID = 1323359457756653096L;

	public TaskView(Task task) {
		super(task);
		setItemDialog(new TaskDialog(task, getColor()));
	}

}
