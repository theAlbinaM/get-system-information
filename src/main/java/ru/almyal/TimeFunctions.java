package ru.almyal;

import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinBase;

public class TimeFunctions {
    private TimeFunctions() {
    }

    static String getSystemTime() {
        WinBase.SYSTEMTIME systemtime = new WinBase.SYSTEMTIME();
        Kernel32.INSTANCE.GetSystemTime(systemtime);
        return "System time: " + systemtime;
    }

    static String getLocalTime() {
        WinBase.SYSTEMTIME localtime = new WinBase.SYSTEMTIME();
        Kernel32.INSTANCE.GetLocalTime(localtime);
        return "Local time: " + localtime;
    }
}
