package org.avm.vaadin.aspect.widget.color;

public enum Shade {

	LIGHT("light"), LIGHTER("lighter"), LIGHTEST("lightest"), DARK("dark"), DARKER("darker"), DARKEST("darkest"), UNDEFINED("");

	private final String shade;

	private Shade(String shade) {
		this.shade = shade;
	}

	@Override
	public String toString() {
		return shade;
	}
}
