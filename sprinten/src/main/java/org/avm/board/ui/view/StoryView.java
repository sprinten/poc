package org.avm.board.ui.view;

import org.avm.board.ui.view.dialog.StoryDialog;
import org.avm.common.domain.Story;

public class StoryView extends AbstractItemView<Story> {

	private static final long serialVersionUID = 1323359457756653096L;

	public StoryView(Story story) {
		super(story);
		setItemDialog(new StoryDialog(story, getColor()));
	}
}
