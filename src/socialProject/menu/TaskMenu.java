package socialProject.menu;

import socialProject.interfaces.ITaskController;
import socialProject.reader.CommandLineReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by pashc on 04.09.2016.
 */
public class TaskMenu {

   // private static final String PATH_TO_TASKS_ON_SERVER = "E:\\Java\\Temp\\Tests\\";

    public static void taskMenu(ITaskController iTaskController) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1.Perform Task");
            System.out.println("0.Exit");

            String choise = scanner.nextLine();
            switch (choise) {
                case "1":
                    System.out.println("Input path on your PC to make socialProject.task copy");
                    String path = scanner.nextLine();
                    String fileName = path.split("\\.")[0];
                    int id = Integer.parseInt(String.valueOf(fileName.charAt(fileName.length() - 1)));
                    String pathTo = "C:\\Java\\Tests\\" + "Test" + id + "\\" +
                            "RunTask" + id + ".java";
                    try {
                        if (Files.exists(Paths.get(pathTo))) Files.delete(Paths.get(pathTo));
                        Files.copy(Paths.get(path), Paths.get(pathTo));
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                    String out = CommandLineReader.executeCommand("javac " + pathTo);
                    if (out.length() == 0) System.out.println("Compilation is successful");
                    else System.out.println("wrong solution\n" + out);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Error!");
            }

        }


    }
}
