module at.fhtw.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.fhtw.todolist.view to javafx.fxml;
    opens at.fhtw.todolist.model to javafx.base;
    exports at.fhtw.todolist.view to javafx.fxml;
    exports at.fhtw.todolist to javafx.graphics;
}