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
import remoteapi.professor.PostProfessorApi;
import remoteapi.professor.Professor;
import remoteapi.student.PostStudentApi;
import remoteapi.student.Student;

import java.io.IOException;

public class professorRegistrationController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField department,office,research,errorText;

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
        professorCall(event);
        Stage stage;


        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("welcome_customer.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }

    private void professorCall(ActionEvent event) {
        Professor professor = new Professor();

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String broncoId = stage.getUserData().toString();

        professor.setBroncoId(broncoId);
        professor.setDepartment(department.getText());
        professor.setOffice(office.getText());
        professor.setResearch(research.getText());

        PostProfessorApi postProfessorApi = new PostProfessorApi(professor);
        postProfessorApi.setOnSucceeded(apiEvent -> {
            System.out.println("Professor saved");
        });
        new Thread(postProfessorApi).start();
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
