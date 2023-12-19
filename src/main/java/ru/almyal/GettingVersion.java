package ru.almyal;

import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinNT;

class GettingVersion {
    private GettingVersion() {
    }

    static String getVersion() {
        WinNT.OSVERSIONINFO lpVersionInfo = new WinNT.OSVERSIONINFO();
        Kernel32.INSTANCE.GetVersionEx(lpVersionInfo);
        return "Version: " + lpVersionInfo.dwMajorVersion.longValue() + "."
                + lpVersionInfo.dwMinorVersion.longValue();
    }
}
