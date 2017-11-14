package com;

import com.layouts.MainApp;

import javax.swing.*;

/**
 * Created by mitola1 on 14/11/2017.
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new MainApp().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
