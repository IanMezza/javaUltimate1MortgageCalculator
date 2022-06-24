package com.ianmeza;

public class Main {
    public static void main(String[] args) {
        var control = new TextBox();
        control.disable();
        System.out.println(control.isEnable());
    }
}
