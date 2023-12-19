package ru.almyal;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.*;
import com.sun.jna.ptr.IntByReference;

class GettingComputerAndUserNames {
    private GettingComputerAndUserNames() {
    }

    static String getComputerName() {
        char[] buffer = new char[WinBase.MAX_COMPUTERNAME_LENGTH + 1];
        IntByReference lpnSize = new IntByReference(buffer.length);
        if (!Kernel32.INSTANCE.GetComputerName(buffer, lpnSize)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return "Computer name: " + Native.toString(buffer);
    }

    static String getUserName() {
        char[] buffer = new char[20];
        IntByReference nSize = new IntByReference(buffer.length);
        if (Advapi32.INSTANCE.GetUserNameW(buffer, nSize)) {
            return "User name: " + Native.toString(buffer);
        }
        return null;
    }
}
