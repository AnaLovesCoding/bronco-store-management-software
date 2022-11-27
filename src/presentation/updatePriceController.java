package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class updatePriceController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField productID,productName,price,errorField;

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
    protected void onUpdatePriceClick(ActionEvent event) throws IOException {
        if(productID.getText().isEmpty()){
            errorField.setVisible(true);
            errorField.setText(String.format("ShopProduct ID cannot be empty"));
            return;
        }
        if(productName.getText().isEmpty()){
            errorField.setVisible(true);
            errorField.setText(String.format("ShopProduct Name cannot be empty"));
            return;
        }
        if(price.getText().isEmpty()){
            errorField.setVisible(true);
            errorField.setText(String.format("price cannot be empty"));
            return;
        }
        else{
            errorField.setVisible(true);
            errorField.setText(String.format("New Price Updated Successfully"));
            productID.setText(null);
            productName.setText(null);
            price.setText(null);
            return;
        }
    }

}

