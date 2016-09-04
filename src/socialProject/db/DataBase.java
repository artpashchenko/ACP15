package socialProject.db;

import socialProject.task.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pashc on 04.09.2016.
 */
public class DataBase {

    private List<Task> taskArray;
    private String dBPath;

    public DataBase(String dBPath) {
        this.dBPath = dBPath;
        this.taskArray = new ArrayList<>();
    }

    public List<Task> getTaskArray() {
        return taskArray;
    }


    public String getdBPath() {
        return dBPath;
    }

    public boolean initDB() {

        try {
            Files.walk(Paths.get(dBPath)).filter(Files::isRegularFile).map(Path::toFile).forEach(file -> {
                String fullFileName = file.getName();
                String fileName = fullFileName.split("\\.")[0];
                String filePath = file.getAbsolutePath();
                int id = Integer.parseInt(String.valueOf(fileName.charAt(fileName.length() - 1)));
                taskArray.add(id - 1, new Task(id, fullFileName, filePath));

            });

            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }
}
