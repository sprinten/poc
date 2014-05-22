package org.avm.sprinten.ui.pages;

import org.vaadin.navigator7.ParamChangeListener;
import org.vaadin.navigator7.uri.ExtraValidator;

import com.vaadin.ui.ComponentContainer;

public interface NavigablePage extends ParamChangeListener, ExtraValidator {

	/**
	 * @param component
	 */
	public abstract void setContent(ComponentContainer component);

}