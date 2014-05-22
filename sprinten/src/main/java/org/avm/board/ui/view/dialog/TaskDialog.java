package org.avm.board.ui.view.dialog;

import org.avm.board.ui.view.form.TaskForm;
import org.avm.common.domain.Task;
import org.avm.framework.ui.form.ItemDialog;
import org.avm.vaadin.aspect.widget.color.Color;

import com.vaadin.ui.Alignment;

public class TaskDialog extends ItemDialog<Task> {

	private static final long serialVersionUID = -6854288772791968352L;

	private TaskForm form;

	public TaskDialog(Task task, Color color) {
		super(task);

		form = new TaskForm(task, color);
		getRootLayout().addComponent(form);
		getRootLayout().setComponentAlignment(form, Alignment.MIDDLE_CENTER);
	}

	public void setColor(Color newColor) {
		form.setColor(newColor);
	}
}
