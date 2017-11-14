package com.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mitola1 on 14/11/2017.
 */
public class ConsoleIntegration {
    public String consoleExecOutput(String inputCommand) throws IOException, InterruptedException {
        String consoleOutput="";

        Process proc = Runtime.getRuntime().exec(inputCommand);

        // Read the output

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line = "";
        while((line = reader.readLine()) != null) {
            System.out.print(line + "\n");
            consoleOutput=consoleOutput+line + "\n";
        }

        proc.waitFor();

        return consoleOutput;
    }

    public void openTerminalWithCommand(String inputCommand){
        String nameOS = System.getProperty("os.name");

        System.out.println(nameOS);

        if (nameOS.startsWith("Windows")){
            //// windows only
        /*Process p = Runtime.getRuntime().exec("cmd /c start cmd.exe");
        p.waitFor();*/
        } else if (nameOS.startsWith("Mac")){
            //Mac
        /*
        Runtime.getRuntime().exec("/usr/bin/open -a Terminal /path/to/the/executable");
         */

        } else if (nameOS.startsWith("Linux")){
            //Linux      // GNU/Linux -- example

            //Runtime.getRuntime().exec("/usr/bin/x-terminal-emulator --disable-factory -e cat README.txt");

        }
    }
}
