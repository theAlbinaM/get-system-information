package ru.almyal;

import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.IntByReference;

class GettingSystemParameters {
    private GettingSystemParameters() {
    }

    private static final String ERR = "Error";

    private interface User32Parameters extends ru.almyal.User32 {
        int SPI_ICONVERTICALSPACING = 0x0018;
        int SPI_GETMOUSESPEED = 0x0070;
    }

    static String getSystemParameterOfIconVerticalSpacing() {
        IntByReference intPtr = new IntByReference();
        if (User32.INSTANCE.SystemParametersInfo(
                new WinDef.UINT(User32Parameters.SPI_ICONVERTICALSPACING),
                new WinDef.UINT(0),
                new WinDef.PVOID(intPtr.getPointer()),
                new WinDef.UINT(0))) {
            return "Value of Icon Vertical Spacing: " + intPtr.getValue();
        }
        return ERR;
    }

    static String getSystemParameterOfMouseSpeed() {
        IntByReference intPtr = new IntByReference();
        if (User32.INSTANCE.SystemParametersInfo(
                new WinDef.UINT(User32Parameters.SPI_GETMOUSESPEED),
                new WinDef.UINT(0),
                new WinDef.PVOID(intPtr.getPointer()),
                new WinDef.UINT(0))) {
            return "Value of Mouse speed: " + intPtr.getValue();
        }
        return ERR;
    }
}
