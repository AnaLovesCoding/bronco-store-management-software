package presentation;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BsmNewCustomerRegistration {
    @FXML
    private TextArea welcomeText;
    @FXML
    private TextField firstName,lastName,phone,number,street,city,state,zip,broncoID,errorField;
    @FXML
    private DatePicker dob;
    @FXML
    private CheckBox isProfessor,isStudent;

    @FXML
    protected void onRegisterClick() {
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
        }

    }

}
