package ru.almyal;

import com.sun.jna.platform.win32.WinDef;

import java.awt.*;

class ColorFunctions {
    private ColorFunctions() {
    }

    private static final String R = "r: ";
    private static final String G = ", g: ";
    private static final String B = ", b: ";

    private interface User32Color extends User32 {
        int COLOR_HIGHLIGHTTEXT = 14;
        int COLOR_WINDOWTEXT = 8;
    }

    static String getHighlightTextColor() {
        int rgb = User32.INSTANCE.GetSysColor(User32Color.COLOR_HIGHLIGHTTEXT).intValue();
        return "Highlight text color in RGB: " + calculateRGBColors(rgb);
    }

    static String getWindowTextColor() {
        int rgb = User32.INSTANCE.GetSysColor(User32Color.COLOR_WINDOWTEXT).intValue();
        return "Window text color in RGB: " + calculateRGBColors(rgb);
    }

    static String setHighlightTextColor(int red, int green, int blue) {
        int targetColor = calculateTargetColorToChange(red, green, blue);
        int[] lpaElements = new int[]{User32Color.COLOR_HIGHLIGHTTEXT};
        WinDef.DWORD[] lpaRgbValues = new WinDef.DWORD[]{new WinDef.DWORD(targetColor)};
        if (User32.INSTANCE.SetSysColors(1, lpaElements, lpaRgbValues)) {
            return "Changed highlight text color in RGB: " + R + red + G + green + B + blue;
        }
        return "Error";
    }

    static String setWindowTextColor(int red, int green, int blue) {
        int targetColor = calculateTargetColorToChange(red, green, blue);
        int[] lpaElements = new int[]{User32Color.COLOR_WINDOWTEXT};
        WinDef.DWORD[] lpaRgbValues = new WinDef.DWORD[]{new WinDef.DWORD(targetColor)};
        if (User32.INSTANCE.SetSysColors(1, lpaElements, lpaRgbValues)) {
            return "Changed window text color in RGB: " + R + red + G + green + B + blue;
        }
        return "Error";
    }

    private static String calculateRGBColors(int rgb) {
        Color color = new Color(rgb);
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        return R + red + G + green + B + blue;
    }

    private static int calculateTargetColorToChange(int red, int green, int blue) {
        String redBinary = Integer.toBinaryString(red);
        String greenBinary = Integer.toBinaryString(green);
        String blueBinary = Integer.toBinaryString(blue);
        if (redBinary.length() < 8) redBinary = addHighOrderBit(redBinary);
        if (greenBinary.length() < 8) greenBinary = addHighOrderBit(greenBinary);
        if (blueBinary.length() < 8) blueBinary = addHighOrderBit(blueBinary);
        return Integer.parseInt(redBinary + greenBinary + blueBinary, 2);
    }

    private static String addHighOrderBit(String binary) {
        if (binary.length() == 8) return binary;
        return addHighOrderBit("0" + binary);
    }
}
