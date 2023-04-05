package at.fhtw.todolist.view;

import at.fhtw.todolist.model.Tour;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TodoListView implements Initializable {
    @javafx.fxml.FXML
    private TableView<Tour> tourTable;
    @javafx.fxml.FXML
    private TableColumn<Tour, String> colTourFrom;
    @javafx.fxml.FXML
    private TableColumn<Tour, String> colTourTo;
    @javafx.fxml.FXML
    private TableColumn<Tour, Integer> colTourDistance;

    @Override
    public void initialize(URL location, ResourceBundle rb) {
        //Todo Implement a view model class
        //sample items
        Tour tour1 = new Tour(1, "New York", "Los Angeles", 2799);
        Tour tour2 = new Tour(2, "London", "Paris", 344);
        Tour tour3 = new Tour(3, "Tokyo", "Sydney", 7795);

        // Add the sample data to a list
        ObservableList<Tour> tourList = FXCollections.observableArrayList();

        tourList.add(tour1);
        tourList.add(tour2);
        tourList.add(tour3);
        tourTable.setItems(tourList);
        tourTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        colTourDistance.setCellValueFactory(new PropertyValueFactory<Tour, Integer>("Distance")); //
        colTourFrom.setCellValueFactory(new PropertyValueFactory<Tour, String>("To"));
        colTourTo.setCellValueFactory(new PropertyValueFactory<Tour, String>("From"));

    }
}
