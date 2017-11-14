package com.layouts;

import com.logic.ConsoleIntegration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Created by mitola1 on 14/11/2017.
 */
public class MainApp {
    public JPanel panelMain;
    private JTabbedPane mainTabber;
    private JTextField msg;
    private JTextPane consoleOutput;
    private JButton msgSend;

    public MainApp() {

        ConsoleIntegration console = new ConsoleIntegration();

        msgSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // call to the logic class to execute the command and return the output to the console.
                // On this event we also take the data from the text field
                String consoleCommand = msg.getText();

                try {
                    console.consoleExecOutput(consoleCommand);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

            }
        });
        msg.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB){
                    System.out.println("TAB press" + msg.getText());
                }
                // listen for TAB so we can return the appropriate result
                super.keyTyped(e);
            }
        });


    }
}
