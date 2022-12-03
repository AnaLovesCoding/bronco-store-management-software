package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import remoteapi.product.PostProductApi;
import remoteapi.product.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class productRegistrationController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField productID, productName, price, errorField;
    @FXML
    private ProgressIndicator progressBar;


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
    protected void onAddProductClick() {
        if (productName.getText().isEmpty()) {
            errorField.setVisible(true);
            errorField.setText("ShopProduct Name cannot be empty");
            return;
        }
        if (price.getText().isEmpty()) {
            errorField.setVisible(true);
            errorField.setText("price cannot be empty");
            return;
        }
        submitProduct();
    }

    private void submitProduct() {
        progressBar.setVisible(true);
        Product product = new Product();
        product.setName(productName.getText());
        product.setCurrentPrice(Long.valueOf(price.getText()));

        PostProductApi postProductApi = new PostProductApi(product);
        postProductApi.setOnSucceeded(event -> resetAll());

        new Thread(postProductApi).start();
    }

    private void resetAll() {
        progressBar.setVisible(false);
        errorField.setVisible(true);
        errorField.setText("ShopProduct Added Successfully");
        productID.setText(null);
        productName.setText(null);
        price.setText(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        progressBar.setVisible(false);
    }
}