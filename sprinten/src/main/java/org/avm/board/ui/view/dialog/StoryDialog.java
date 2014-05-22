package org.avm.board.ui.view.dialog;

import org.avm.board.ui.view.form.StoryForm;
import org.avm.common.domain.Story;
import org.avm.framework.ui.form.ItemDialog;
import org.avm.vaadin.aspect.widget.color.Color;

import com.vaadin.ui.Alignment;

public class StoryDialog extends ItemDialog<Story> {

	private static final long serialVersionUID = -6854288772791968352L;

	private StoryForm form;

	public StoryDialog(Story story, Color color) {
		super(story);

		form = new StoryForm(story, color);
		getRootLayout().addComponent(form);
		getRootLayout().setComponentAlignment(form, Alignment.MIDDLE_CENTER);
	}

	public void setColor(Color newColor) {
		form.setColor(newColor);
	}
}
