module at.fhtw.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires org.json;


    opens at.fhtw.app.view to javafx.fxml;
    opens at.fhtw.app.model to javafx.base;
    exports at.fhtw.app.view to javafx.fxml;
    exports at.fhtw.app to javafx.graphics;
}