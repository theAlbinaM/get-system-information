package ru.almyal;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinUser;

class GettingSystemMetrics {
    private GettingSystemMetrics() {
    }

    static String getSysMetricsOfWindow() {
        return "The minimum window's width: " + User32.INSTANCE.GetSystemMetrics(WinUser.SM_CXMIN)
                + "; the minimum window's height: " + User32.INSTANCE.GetSystemMetrics(WinUser.SM_CYMIN);
    }

    static String getSysMetricsOfScreen() {
        return "Screen's width: " + User32.INSTANCE.GetSystemMetrics(WinUser.SM_CXSCREEN) +
                "; screen's height: " + User32.INSTANCE.GetSystemMetrics(WinUser.SM_CYSCREEN);
    }

    static String getSysMetricsOfFMouseWheel() {
        if (User32.INSTANCE.GetSystemMetrics(WinUser.SM_MOUSEWHEELPRESENT) != 0) {
            return "Mouse wheel is installed.";
        }
        return "Mouse wheel is not installed.";
    }
}