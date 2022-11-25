package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class generateReportController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField errorField;
    @FXML
    private DatePicker startDate,endDate;

    @FXML
    protected void onLogoutClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("bsm_home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onAdminPageClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("admin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onGenerateReportClick(ActionEvent event) throws IOException {
        if(endDate.getValue().compareTo(startDate.getValue())<0){
            errorField.setVisible(true);
            errorField.setText(String.format("end Date should be grater than the Start Date"));
            return;
        }
        else{
            errorField.setVisible(false);
        }


    }


}

