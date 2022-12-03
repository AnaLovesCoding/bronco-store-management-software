package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class BsmNewCustomerRegistrationController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextArea welcomeText;
    @FXML
    private TextField firstName,lastName,phone,number,street,city,state,zip,broncoID,errorField;
    @FXML
    private DatePicker dob;
    @FXML
    private CheckBox isProfessor,isStudent;

    @FXML
    protected void onRegisterClick(ActionEvent event)throws IOException {
        if(firstName.getText().isEmpty()){
            errorField.setVisible(true);
            errorField.setText(String.format("First name cannot be empty"));
            return;
        }
        if(lastName.getText().isEmpty()){
            errorField.setVisible(true);
            errorField.setText(String.format("Last name cannot be empty"));
            return;
        }
        if(phone.getText().isEmpty()){
            errorField.setVisible(true);
            errorField.setText(String.format("Phone cannot be empty"));
            return;
        }
        if(number.getText().isEmpty()){
            errorField.setVisible(true);
            errorField.setText(String.format("street number cannot be empty"));
            return;
        }
        if(street.getText().isEmpty()){
            errorField.setVisible(true);
            errorField.setText(String.format("street cannot be empty"));
            return;
        }
        if(city.getText().isEmpty()){
            errorField.setVisible(true);
            errorField.setText(String.format("city cannot be empty"));
            return;
        }
        if(state.getText().isEmpty()){
            errorField.setVisible(true);
            errorField.setText(String.format("state cannot be empty"));
            return;
        }
        if(zip.getText().isEmpty()){
            errorField.setVisible(true);
            errorField.setText(String.format("zip cannot be empty"));
            return;
        }
        if(broncoID.getText().isEmpty()){
            errorField.setVisible(true);
            errorField.setText(String.format("Bronco ID cannot be empty"));
            return;
        }
      if(isProfessor.isSelected() == false && isStudent.isSelected() == false){
          errorField.setVisible(true);
          errorField.setText(String.format("Select either customer is a professor or student"));
          return;
      }
      if(dob.getValue() == null){
          errorField.setVisible(true);
          errorField.setText(String.format("DOB cannot be empty"));
          return;
      }
        else{
            errorField.setVisible(false);
            welcomeText.setText(String.format("First Name: %s, Last Name: %s, " +
                            "Date of Birth: %s, Phone: %s, " +
                            "Address- Number: %s, street: %s, " +
                            "city: %s, state: %s, zip: %s, " +
                            "broncoID: %s, isProfessor: %s, isStudent: %s",
                    firstName.getText(), lastName.getText(),
                    dob.getValue(), phone.getText(),
                    number.getText(), street.getText(),
                    city.getText(), state.getText(),
                    zip.getText(), broncoID.getText(),
                    isProfessor.isSelected(), isStudent.isSelected()));

            if(isStudent.isSelected() && (isProfessor.isSelected()==false)){
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("student_registration.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
          if(isProfessor.isSelected() && (isStudent.isSelected()==false)){
              Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("professor_registration.fxml"));
              stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              scene = new Scene(root);
              stage.setScene(scene);
              stage.show();
          }
          if(isProfessor.isSelected() && isStudent.isSelected()){
              Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("both_student_professor_registration.fxml"));
              stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              scene = new Scene(root);
              stage.setScene(scene);
              stage.show();
          }

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
