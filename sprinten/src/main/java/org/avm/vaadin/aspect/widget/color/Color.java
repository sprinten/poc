package org.avm.vaadin.aspect.widget.color;

public enum Color {

	BLUE("blue"), BROWN("brown"), GRAY("gray"), GREEN("green"), MAGENTA("magenta"), ORANGE("orange"), PURPLE("purple"), RED("red"), UNDEFINED("");

	private final String color;

	private Color(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return color;
	}
}
