package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class professorRegistrationController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField department,office,research,errorText;
    @FXML
    private TextArea professorDetailsText;

    @FXML
    protected void onSubmitClick(ActionEvent event)throws IOException {
        if(department.getText().isEmpty()){
            errorText.setVisible(true);
            errorText.setText(String.format("department cannot be empty"));
            return;
        }
        if(office.getText().isEmpty()){
            errorText.setVisible(true);
            errorText.setText(String.format("office cannot be empty"));
            return;
        }
        if(research.getText().isEmpty()){
            errorText.setVisible(true);
            errorText.setText(String.format("research cannot be empty"));
            return;
        }
        else {
            errorText.setVisible(false);
            professorDetailsText.setText(String.format("department: %s, " +
                    "office: %s, research: %s",
                    department.getText(),office.getText(),
                    research.getText()));

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("welcome_customer.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    protected void onCancelClick(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("bsm_home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
