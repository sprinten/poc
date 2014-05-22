package org.avm.vaadin.aspect.color;

import java.awt.Color;

public class Rounding {

	private static final Color[] COLORS = new Color[] { Color.decode("#bb00bb"), Color.decode("#b8bbbe"), Color.decode("#91bd09"), Color.decode("#1577b0"),
			Color.decode("#ffaa55"), Color.decode("#ee9900"), Color.decode("#ee9903"), Color.decode("#dd7711"), };

	public static Color lightenRGB(Color color, int start) {
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();

		return new Color(getColor(r, start), getColor(g, start), getColor(b, start));
	}

	private static int getColor(int value, int start) {

		// return (int) (start + value * (256.d - start) / 256.d - 1);

		return start + value - 1 - (int) (start * value / 256.d);
	}

	public static Color lightenHSL(Color color, int percent) {
		HSLColor hsl = new HSLColor(color);

		float luminance = hsl.getLuminance() * (1 + percent / 100.f);
		luminance = clamp(luminance);

		hsl = new HSLColor(hsl.getHue(), hsl.getSaturation(), luminance, 1.0f);
		return hsl.getRGB();
	}

	public static Color fadeoutHSL(Color color, int percent) {
		HSLColor hsl = new HSLColor(color);

		float luminance = hsl.getAlpha() * (1 + percent / 100.f);
		luminance = clamp(luminance);

		hsl = new HSLColor(hsl.getHue(), hsl.getSaturation(), luminance, 1.0f);
		return hsl.getRGB();
	}

	public static float clamp(float val) {
		return Math.min(100, Math.max(0, val));
	}

	public static Color rgbColor1(Color color) {
		return lightenRGB(color, 64);
	}

	public static Color rgbColor2(Color color) {
		return lightenRGB(color, 48);
	}

	public static Color rgbBorder1(Color color) {
		return lightenRGB(color, 146);
	}

	public static Color rgbBorder2(Color color) {
		return lightenRGB(color, 230);
	}

	public static Color hslColor1(Color color) {
		return lightenHSL(color, 9);
	}

	public static void main(String[] args) {
		for (int i = 0; i < COLORS.length; i++) {
			System.out.println("[rgb]:[" + rgbColor1(COLORS[i]) + "]");
			System.out.println("[hsl]:[" + hslColor1(COLORS[i]) + "]");
			System.out.println();
			// System.out.println(rgbBorder1(COLORS[i]));
			// System.out.println(rgbColor2(COLORS[i]));
			// System.out.println(rgbBorder2(COLORS[i]));
		}

	}

}
