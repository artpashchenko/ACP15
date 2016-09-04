package socialProject.controller;

import socialProject.db.DataBase;
import socialProject.interfaces.ITaskController;
import socialProject.task.Task;

/**
 * Created by pashc on 04.09.2016.
 */
public class TaskController implements ITaskController {


    public DataBase dataBase;

    public  TaskController(DataBase dataBase){
        this.dataBase = dataBase;
    }



    @Override
    public boolean performTask(Task task) {
        return false;
    }
}
