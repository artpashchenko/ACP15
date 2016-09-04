import controller.TaskController;
import db.DataBase;
import menu.TaskMenu;

/**
 * Created by pashc on 04.09.2016.
 */
public class RunApp {

    public static void main(String[] args) {
        DataBase db = new DataBase("C:\\Java\\Tasks\\");
        db.initDB();
        TaskMenu.taskMenu(new TaskController(db));
    }
}
