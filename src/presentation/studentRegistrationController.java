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
import java.time.LocalDate;
import java.util.Date;

public class studentRegistrationController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField major,minor,errorText;
    @FXML
    private DatePicker startDate,gradDate;
    @FXML
    private TextArea studentDetailsText;

    @FXML
    protected void onSubmitClick(ActionEvent event)throws IOException {
        if(major.getText().isEmpty()){
            errorText.setVisible(true);
            errorText.setText(String.format("major cannot be empty"));
            return;
        }
        if(startDate.getValue()==null){
            errorText.setVisible(true);
            errorText.setText(String.format("Start Date cannot be empty"));
            return;
        }
        if(gradDate.getValue() != null && (gradDate.getValue().compareTo(startDate.getValue())<0)){
            errorText.setVisible(true);
            errorText.setText(String.format("Grad Date should be grater than the Start Date"));
            return;
        }
        else {
            errorText.setVisible(false);
            studentDetailsText.setText(String.format("Major: %s, Minor: %s, " +
                            "Start Date: %s, Grad Date: %s",
                    major.getText(),minor.getText(),
                    startDate.getValue(),gradDate.getValue()));
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
