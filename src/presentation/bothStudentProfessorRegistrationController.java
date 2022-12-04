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

public class bothStudentProfessorRegistrationController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField major,minor,errorText,department,office,research;
    @FXML
    private DatePicker startDate,gradDate;

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

        Student student = new Student();

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String broncoId = stage.getUserData().toString();

        student.setBroncoId(broncoId);
        student.setMajor(major.getText());
        student.setMinor(minor.getText());
        student.setStartDate(String.valueOf(startDate.getValue()));
        student.setGradDate(String.valueOf(gradDate.getValue()));

        PostStudentApi postStudentApi = new PostStudentApi(student);
        postStudentApi.setOnSucceeded(apiEvent -> {
            System.out.println("Student saved");
        });
        new Thread(postStudentApi).start();

        Professor professor = new Professor();

        Node node1 = (Node) event.getSource();
        Stage stage1 = (Stage) node1.getScene().getWindow();
        String broncoId1 = stage1.getUserData().toString();

        professor.setBroncoId(broncoId1);
        professor.setDepartment(department.getText());
        professor.setOffice(office.getText());
        professor.setResearch(research.getText());

        PostProfessorApi postProfessorApi = new PostProfessorApi(professor);
        postProfessorApi.setOnSucceeded(apiEvent -> {
            System.out.println("Professor saved");
        });
        new Thread(postProfessorApi).start();


            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("welcome_customer.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

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
