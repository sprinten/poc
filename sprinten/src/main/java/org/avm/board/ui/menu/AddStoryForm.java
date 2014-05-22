package org.avm.board.ui.menu;

import org.avm.board.ui.Whiteboard;
import org.avm.board.ui.view.StoryView;
import org.avm.common.domain.Story;
import org.avm.sprinten.ui.content.Navigation;
import org.avm.sprinten.ui.menu.PopupWindow;

import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.ui.Button.ClickEvent;

public class AddStoryForm extends ConfigurationForm {

	private static final long serialVersionUID = 4165065192676778813L;

	private PropertysetItem item = new PropertysetItem();
	public AddStoryForm(Whiteboard whiteboard) {
		super(whiteboard);

		setCaption(Navigation.getText("page.board.form.add.story"));
		// Some data to bind the form to
		item.addItemProperty("rowIndex", new ObjectProperty<Integer>(0));

		setItemDataSource(item);

		setVisibleItemProperties(new Object[] { "rowIndex" });
	}

	public void buttonClick(ClickEvent event) {
		Integer row = Integer.valueOf(item.getItemProperty("rowIndex").getValue().toString());
		getBoard().addItemView(new StoryView(new Story()), 1, row);
		((PopupWindow)getParent().getParent()).exit();
	}
}
