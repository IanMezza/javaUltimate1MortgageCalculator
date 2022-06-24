package com.ianmeza;

public class UIControl {
    private boolean isEnable = true;

    public void enable() {
        isEnable = true;
    }

    public void disable() {
        isEnable = false;
    }

    public boolean isEnable() {
        return isEnable;
    }
}
