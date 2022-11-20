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
    private TextField firstName,lastName,phone,number,street,city,state,zip,broncoID;
    @FXML
    private DatePicker dob;
    @FXML
    private CheckBox isProfessor,isStudent;

    @FXML
    protected void onRegisterClick() {
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
