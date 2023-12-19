package ru.almyal;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.*;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

import static com.sun.jna.platform.win32.WinDef.MAX_PATH;

class GettingDirectories {
    private GettingDirectories() {
    }

    private interface Kernel32Directory extends StdCallLibrary {
        Kernel32Directory INSTANCE = Native.load("kernel32", Kernel32Directory.class, W32APIOptions.DEFAULT_OPTIONS);

        WinDef.UINT GetWindowsDirectoryA(byte[] lpBuffer, WinDef.UINT uSize);

        WinDef.UINT GetSystemDirectoryA(byte[] lpBuffer, WinDef.UINT uSize);
    }

    static String getWindowsDirectory() {
        byte[] buffer = new byte[MAX_PATH];
        Kernel32Directory.INSTANCE.GetWindowsDirectoryA(buffer, new WinDef.UINT(MAX_PATH));
        return "Windows directory: " + Native.toString(buffer);
    }

    static String getSystemDirectory() {
        byte[] buffer = new byte[MAX_PATH];
        Kernel32Directory.INSTANCE.GetSystemDirectoryA(buffer, new WinDef.UINT(MAX_PATH));
        return "System directory: " + Native.toString(buffer);
    }

    static String getTempPath() {
        char[] buffer = new char[MAX_PATH];
        Kernel32.INSTANCE.GetTempPath(new WinDef.DWORD(MAX_PATH), buffer);
        return "Temp Path: " + Native.toString(buffer);
    }
}
