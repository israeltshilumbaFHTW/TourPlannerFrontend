module at.fhtw.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires org.json;
    requires com.fasterxml.jackson.databind;


    opens at.fhtw.app.view to javafx.fxml;
    opens at.fhtw.app.model to javafx.base;
    exports at.fhtw.app.view to javafx.fxml;
    exports at.fhtw.app to javafx.graphics;
    exports at.fhtw.app.viewModel to javafx.fxml;
    exports at.fhtw.app.helperServices.Form to javafx.fxml;
    exports at.fhtw.app.model to com.fasterxml.jackson.databind;
    exports at.fhtw.app.helperServices.Enums to javafx.fxml;
    exports at.fhtw.app.view.components to javafx.fxml;
}