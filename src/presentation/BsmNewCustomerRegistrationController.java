package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import remoteapi.address.Address;
import remoteapi.address.PostAddressApi;
import remoteapi.bsmUser.BSMUser;
import remoteapi.bsmUser.PostBSMUserApi;

import java.io.IOException;

public class BsmNewCustomerRegistrationController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField firstName, lastName, phone, number, street, city, state, zip, broncoID, errorField, addressId;
    @FXML
    private DatePicker dob;
    @FXML
    private CheckBox isProfessor, isStudent;

    @FXML
    protected void onRegisterClick(ActionEvent event) throws IOException {

        if (firstName.getText().isEmpty()) {
            errorField.setVisible(true);
            errorField.setText(String.format("First name cannot be empty"));
            return;
        }
        if (lastName.getText().isEmpty()) {
            errorField.setVisible(true);
            errorField.setText(String.format("Last name cannot be empty"));
            return;
        }
        if (phone.getText().isEmpty()) {
            errorField.setVisible(true);
            errorField.setText(String.format("Phone cannot be empty"));
            return;
        }
        if (number.getText().isEmpty()) {
            errorField.setVisible(true);
            errorField.setText(String.format("street number cannot be empty"));
            return;
        }
        if (street.getText().isEmpty()) {
            errorField.setVisible(true);
            errorField.setText(String.format("street cannot be empty"));
            return;
        }
        if (city.getText().isEmpty()) {
            errorField.setVisible(true);
            errorField.setText(String.format("city cannot be empty"));
            return;
        }
        if (state.getText().isEmpty()) {
            errorField.setVisible(true);
            errorField.setText(String.format("state cannot be empty"));
            return;
        }
        if (zip.getText().isEmpty()) {
            errorField.setVisible(true);
            errorField.setText(String.format("zip cannot be empty"));
            return;
        }
        if (broncoID.getText().isEmpty()) {
            errorField.setVisible(true);
            errorField.setText(String.format("Bronco ID cannot be empty"));
            return;
        }
        if (!isProfessor.isSelected() && !isStudent.isSelected()) {
            errorField.setVisible(true);
            errorField.setText(String.format("Select either customer is a professor or student"));
            return;
        }
        if (dob.getValue() == null) {
            errorField.setVisible(true);
            errorField.setText(String.format("DOB cannot be empty"));
        } else {
            addressCall();
            bsmUserCall();
            if (isStudent.isSelected() && (!isProfessor.isSelected())) {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("student_registration.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setUserData(broncoID.getText());
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            if (isProfessor.isSelected() && (!isStudent.isSelected())) {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("professor_registration.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setUserData(broncoID.getText());
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            if (isProfessor.isSelected() && isStudent.isSelected()) {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("both_student_professor_registration.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setUserData(broncoID.getText());
                stage.setUserData(isStudent.isSelected());
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    private void bsmUserCall() {
        BSMUser bsmUser = new BSMUser();
        bsmUser.setBroncoId(broncoID.getText());
        bsmUser.setFirstName(firstName.getText());
        bsmUser.setLastName(lastName.getText());
        bsmUser.setDob(dob.getValue().toString());
        bsmUser.setPhone(phone.getText());
        if (isStudent.isSelected() && !isProfessor.isSelected()) {
            bsmUser.setUserType("STUDENT");
        }
        if (isProfessor.isSelected() && !isStudent.isSelected()) {
            bsmUser.setUserType("PROFESSOR");
        }
        if (isStudent.isSelected() && isProfessor.isSelected()) {
            bsmUser.setUserType("STUDENT_AND_PROFESSOR");
        }
        PostBSMUserApi postBSMUserApi = new PostBSMUserApi(bsmUser);
        postBSMUserApi.setOnSucceeded(apiEvent -> {
            System.out.println("User Saved: " + bsmUser);
        });
        new Thread(postBSMUserApi).start();
    }

    private void addressCall() {
        Address address = new Address();
        address.setStreet(street.getText());
        address.setNumber(Integer.parseInt(number.getText()));
        address.setCity(city.getText());
        address.setState(state.getText());
        address.setZip(Integer.parseInt(zip.getText()));
        PostAddressApi postAddressApi = new PostAddressApi(address);
        postAddressApi.setOnSucceeded(apiEvent -> {
            System.out.println("Address saved");
        });
        new Thread(postAddressApi).start();
    }

    @FXML
    protected void onCancelClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("bsm_home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
