package org.avm.board.ui.view.form;

import org.avm.common.domain.Story;
import org.avm.framework.ui.LazyBeanItem;
import org.avm.framework.ui.form.ItemForm;
import org.avm.vaadin.aspect.widget.color.Color;

public class StoryForm extends ItemForm<Story> {

	private static final long serialVersionUID = 914299786917466508L;

	public StoryForm(Story story, Color color) {
		super(story, color);
		setItemDataSource(new LazyBeanItem<Story>(story));
	}
}
