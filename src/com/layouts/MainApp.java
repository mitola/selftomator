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
    private JTextField msg;
    private JTextPane consoleOutput;
    private JButton msgSend;
    private JTabbedPane mainTabber;
    private JTextField textField1;
    private JButton button1;
    private JScrollPane scrollConsoleWrapper;

    public MainApp() {

        ConsoleIntegration console = new ConsoleIntegration();

        msgSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // call to the logic class to execute the command and return the output to the console.
                // On this event we also take the data from the text field
                String consoleCommand = msg.getText();

                try {
                   consoleOutput.setText(consoleOutput.getText() + console.consoleExecOutput(consoleCommand));
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
                //System.out.println("TAB press" + msg.getText());
                if (e.getKeyCode() == '\n'){
                    System.out.println("ENTER press" + msg.getText());
                }
                // listen for TAB so we can return the appropriate result
                super.keyTyped(e);
            }
        });


    }
}
