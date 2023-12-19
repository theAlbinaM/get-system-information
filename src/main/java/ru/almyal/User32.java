package ru.almyal;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

public interface User32 extends StdCallLibrary {
    User32 INSTANCE = Native.load("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);

    boolean SystemParametersInfo(WinDef.UINT uiAction, WinDef.UINT uiParam,
                                 WinDef.PVOID pvParam, WinDef.UINT fWinIni);

    WinDef.DWORD GetSysColor(int nIndex);

    boolean SetSysColors(int cElements, int[] lpaElements, WinDef.DWORD[] lpaRgbValues);

    boolean GetClipCursor(WinDef.RECT lpRect);

    int GetKeyboardType(int nTypeFlag);

    int ShowCursor(boolean bShow);
}
