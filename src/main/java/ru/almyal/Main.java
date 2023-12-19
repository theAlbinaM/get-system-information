package ru.almyal;

public class Main {
    public static void main(String[] args) {
        System.out.println(GettingComputerAndUserNames.getComputerName());
        System.out.println(GettingComputerAndUserNames.getUserName());

        System.out.println(GettingDirectories.getWindowsDirectory());
        System.out.println(GettingDirectories.getSystemDirectory());
        System.out.println(GettingDirectories.getTempPath());

        System.out.println(GettingVersion.getVersion());

        System.out.println(GettingSystemMetrics.getSysMetricsOfWindow());
        System.out.println(GettingSystemMetrics.getSysMetricsOfScreen());
        System.out.println(GettingSystemMetrics.getSysMetricsOfFMouseWheel());

        System.out.println(GettingSystemParameters.getSystemParameterOfIconVerticalSpacing());
        System.out.println(GettingSystemParameters.getSystemParameterOfMouseSpeed());

        System.out.println(ColorFunctions.getHighlightTextColor());
        System.out.println(ColorFunctions.getWindowTextColor());
        System.out.println(ColorFunctions.setHighlightTextColor(255, 255, 255));
        System.out.println(ColorFunctions.setWindowTextColor(0, 0, 0));
//        System.out.println(ColorFunctions.setHighlightTextColor(25, 205,125));
//        System.out.println(ColorFunctions.setWindowTextColor(200, 40, 150));

        System.out.println(TimeFunctions.getSystemTime());
        System.out.println(TimeFunctions.getLocalTime());

        System.out.println(ExtraFunctions.getClipCursor());
        System.out.println(ExtraFunctions.getKeyboardType());
        System.out.println(ExtraFunctions.getUserDefaultLCID());
        System.out.println(ExtraFunctions.showCursor());
    }
}