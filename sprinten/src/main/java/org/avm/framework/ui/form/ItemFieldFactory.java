package org.avm.framework.ui.form;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.avm.common.domain.Element;
import org.avm.framework.ui.DateTimeField;
import org.avm.vaadin.aspect.theme.Aspect;
import org.joda.time.DateTime;
import org.vaadin.tokenfield.TokenField;

import com.vaadin.data.Item;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class ItemFieldFactory<T extends Element> implements FormFieldFactory {

	private static final long serialVersionUID = -6585073917215420354L;

	@SuppressWarnings("serial")
	public static final Set<String> REQUIRED_HIDDEN_PROPS = new LinkedHashSet<String>() {

		{
			add("id");
			add("version");
			add("dateCreate");
			add("dateChange");
		}
	};

	public Field createField(final Item item, final Object propertyId, final Component uiContext) {
		Class<?> type = item.getItemProperty(propertyId).getType();
		Field field = createFieldByPropertyType(type);
		field.setCaption(createCaptionByPropertyId(propertyId));
		return field;
	}

	/**
	 * If name follows method naming conventions, convert the name to spaced
	 * upper case text. For example, convert "firstName" to "First Name"
	 *
	 * @param propertyId
	 * @return the formatted caption string
	 */
	protected String createCaptionByPropertyId(Object propertyId) {
		String name = propertyId.toString();
		if (name.length() > 0) {

			if (name.indexOf(' ') < 0 && name.charAt(0) == Character.toLowerCase(name.charAt(0))
					&& name.charAt(0) != Character.toUpperCase(name.charAt(0))) {
				StringBuffer out = new StringBuffer();
				out.append(Character.toUpperCase(name.charAt(0)));
				int i = 1;

				while (i < name.length()) {
					int j = i;
					for (; j < name.length(); j++) {
						char c = name.charAt(j);
						if (Character.toLowerCase(c) != c && Character.toUpperCase(c) == c) {
							break;
						}
					}
					if (j == name.length()) {
						out.append(name.substring(i));
					} else {
						out.append(name.substring(i, j));
						out.append(" " + name.charAt(j));
					}
					i = j + 1;
				}

				name = out.toString();
			}
		}

		return name + ": ";
	}

	/**
	 * Creates fields based on the property type.
	 * <p>
	 * The default field type is {@link TextField}. Other field types generated
	 * by this method:
	 * <p>
	 * <b>Boolean</b>: {@link CheckBox}.<br/>
	 * <b>Date</b>: {@link DateField}(resolution: day).<br/>
	 * <b>Item</b>: {@link Form}. <br/>
	 * <b>default field type</b>: {@link TextField}.
	 * <p>
	 *
	 * @param type
	 *            the type of the property
	 * @return the most suitable generic {@link Field} for given type
	 */
	protected Field createFieldByPropertyType(Class<?> type) {
		// Null typed properties can not be edited
		if (type == null) {
			return null;
		}

		// Item field
		if (Item.class.isAssignableFrom(type)) {
			return new Form();
		}

		// Date field
		if (Date.class.isAssignableFrom(type)) {
			final DateField df = new DateField();
			df.setResolution(DateField.RESOLUTION_DAY);
			return df;
		}

		if (DateTime.class.isAssignableFrom(type)) {
			final DateTimeField df = new DateTimeField();
			df.setResolution(DateField.RESOLUTION_DAY);
			return df;
		}

		// Enum field
		if (Enum.class.isAssignableFrom(type)) {
			return new Select();
		}

		// List field
		if (List.class.isAssignableFrom(type)) {
			return new Select();
		}

		// Boolean field
		if (Boolean.class.isAssignableFrom(type)) {
			return new CheckBox();
		}

		// TextArea field
		if (StringBuffer.class.isAssignableFrom(type)) {
			TextArea textArea = new TextArea();
			textArea.addStyleName(Aspect.ITEM_FORM);
			textArea.setNullRepresentation("");
			return textArea;
		}

		// TagField field
		if (Set.class.isAssignableFrom(type)) {
			TokenField tokenField = new TokenField();
			tokenField.setInputWidth("50px");
			tokenField.addStyleName(Aspect.ITEM_FORM);
			return tokenField;
		}

		// Default: TextField
		TextField textField = new TextField();
		textField.addStyleName("form");
		textField.setNullRepresentation("");
		textField.setRequired(true);
		return textField;
	}

}
