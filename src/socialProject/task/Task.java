package socialProject.task;

/**
 * Created by pashc on 04.09.2016.
 */
public class Task {


    private int id;
    private String path;
    private String userName;

    public Task(int id, String name, String path) {

        this.id = id;
        this.userName = name;
        this.path = path;

    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String getPATH() {
        return path;
    }
}
