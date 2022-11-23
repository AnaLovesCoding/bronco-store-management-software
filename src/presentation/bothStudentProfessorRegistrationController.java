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

public class bothStudentProfessorRegistrationController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField major,minor,errorText,department,office,research;
    @FXML
    private DatePicker startDate,gradDate;
    @FXML
    private TextArea studentAndProfessorDetailsText;

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
            studentAndProfessorDetailsText.setText(String.format("Major: %s, " +
                            "Minor: %s,Start Date: %s, Grad Date: %s, " +
                            "Department: %s, Office: %s, Research: %s",
                    major.getText(),minor.getText(),
                    startDate.getValue(),gradDate.getValue(),
                    department.getText(),office.getText(),research.getText()));
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
