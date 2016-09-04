package socialProject.reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by pashc on 04.09.2016.
 */
public class CommandLineReader {

    public static String executeCommand(String command) {

        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return output.toString();
    }
}

