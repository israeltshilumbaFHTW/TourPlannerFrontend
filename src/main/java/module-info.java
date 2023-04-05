module at.fhtw.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.fhtw.app.view to javafx.fxml;
    opens at.fhtw.app.model to javafx.base;
    exports at.fhtw.app.view to javafx.fxml;
    exports at.fhtw.app to javafx.graphics;
}