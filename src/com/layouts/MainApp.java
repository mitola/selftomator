package com.layouts;

import com.logic.ConsoleIntegration;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Properties;

/**
 * Created by mitola1 on 14/11/2017.
 */
public class MainApp {
    public JPanel panelMain;
    private JTextField msg;
    private JTextPane consoleOutput;
    private JButton msgSend;
    private JTabbedPane mainTabber;
    private JScrollPane scrollConsoleWrapper;
    private JTextField cmd1;
    private JButton cmd1b;
    private JTextField cmd2;
    private JTextField cmd3;
    private JTextField cmd4;
    private JButton cmd2b;
    private JButton cmd3b;
    private JButton cmd4b;

    static File file;

    static void saveProperties(Properties p)throws IOException
    {

        FileInputStream in = new FileInputStream("property.dat");
        Properties props = new Properties();
        props.load(in);
        in.close();// Tedst 

        FileOutputStream fr=new FileOutputStream(file);
        p.store(fr,"Properties");
        fr.close();
        System.out.println("After saving properties:"+p);
    }
    void loadPropertiesProperty()throws IOException
    {
        Properties p = new Properties();

        FileInputStream fi=new FileInputStream("property.dat");
        p.load(fi);
        fi.close();

        cmd1.setText(p.getProperty("cmd1"));
        cmd2.setText(p.getProperty("cmd2"));
        cmd3.setText(p.getProperty("cmd3"));
        cmd4.setText(p.getProperty("cmd4"));
        System.out.println("After Loading properties:"+p);
    }

    public void savePropertySet(int cmdNum){
        file=new File("property.dat");
        Properties cmds=new Properties();
        switch (cmdNum){
            case 1:
                cmds.setProperty("cmd1",cmd1.getText());
                break;
            case 2:
                cmds.setProperty("cmd2",cmd2.getText());
                break;
            case 3:
                cmds.setProperty("cmd3",cmd3.getText());
                break;
            case 4:
                cmds.setProperty("cmd4",cmd4.getText());
                break;
        }
        try {
            saveProperties(cmds);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }



    public MainApp() {

        ConsoleIntegration console = new ConsoleIntegration();
        try {
            loadPropertiesProperty();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*Properties prop = new Properties();
        InputStream in = getClass().getResourceAsStream("property.dat");
        try {
            prop.load(in);
            cmd1.setText(prop.getProperty("cmd1"));
            cmd2.setText(prop.getProperty("cmd2"));
            cmd3.setText(prop.getProperty("cmd3"));
            cmd4.setText(prop.getProperty("cmd4"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/


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

        cmd1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                savePropertySet(1);
                super.focusLost(e);
            }
        });
        cmd2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                savePropertySet(2);
                super.focusLost(e);
            }
        });
        cmd3.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                savePropertySet(3);
                super.focusLost(e);
            }
        });
        cmd4.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                savePropertySet(4);
                super.focusLost(e);
            }
        });

    }
}
