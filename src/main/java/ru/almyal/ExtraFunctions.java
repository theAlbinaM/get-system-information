package ru.almyal;

import com.sun.jna.platform.win32.*;

class ExtraFunctions {
    private ExtraFunctions() {
    }

    private interface User32Extra extends ru.almyal.User32 {
        int KEYBOARD_TYPE = 0;
    }

    static String getClipCursor() {
        WinDef.RECT coordinates = new RECTL();
        User32.INSTANCE.GetClipCursor(coordinates);
        return "ClipCursor coordinates: " + coordinates;
    }

    static String getKeyboardType() {
        return "Keyboard type: " + User32.INSTANCE.GetKeyboardType(User32Extra.KEYBOARD_TYPE);
    }

    static String getUserDefaultLCID() {
        return "User default LCID: " + Kernel32.INSTANCE.GetUserDefaultLCID();
    }

    static String showCursor() {
        return "Show cursor: " + User32.INSTANCE.ShowCursor(true);
    }

    private static class RECTL extends WinDef.RECT {
    }
}
