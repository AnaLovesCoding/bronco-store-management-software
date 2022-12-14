package presentation;

import data.BsmUserData;
import data.CartProduct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static data.CartData.cartProductsList;

public class cartController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView cartTable;

    @FXML
    private TableColumn id, name, price, quantity;
    @FXML
    private TextField discount, totalPrice;

    Double totalPriceValue = 0.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cartTable.getColumns().addAll(id, name, quantity, price);
        id.setCellValueFactory(new PropertyValueFactory<CartProduct, String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<CartProduct, String>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<CartProduct, String>("quantity"));
        price.setCellValueFactory(new PropertyValueFactory<CartProduct, String>("price"));

        cartTable.setItems(cartProductsList);

        setUpPrice();
    }

    @FXML
    protected void onLogoutClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("bsm_home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onShopClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("shop.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onSubmitPaymentClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("receipt.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void setUpPrice() {
        discount.setText(BsmUserData.user.getDiscount().toString() + "%");
        cartProductsList.forEach(cartProduct -> {
            totalPriceValue = totalPriceValue + cartProduct.getPrice();
        });

        double discountValue = Double.parseDouble(BsmUserData.user.getDiscount().toString());
        totalPriceValue = totalPriceValue - (
                totalPriceValue * (discountValue / 100)
        );

        totalPrice.setText(totalPriceValue.toString());
    }
}

