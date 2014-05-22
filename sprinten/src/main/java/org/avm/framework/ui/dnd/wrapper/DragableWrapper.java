package org.avm.framework.ui.dnd.wrapper;

import org.avm.board.ui.view.AbstractItemView;


@SuppressWarnings("serial")
public class DragableWrapper extends DropableWrapper {

	public DragableWrapper(AbstractItemView<?> itemView) {
		super();
		setDragStartMode(DragStartMode.WRAPPER);
		getRootLayout().addComponent(itemView);
	}

}