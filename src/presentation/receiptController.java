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

public class receiptController implements Initializable {
    @FXML
    private TableView receiptTable;

    @FXML
    private TableColumn productId, productName, price, quantity;
    @FXML
    private TextField discount, totalPrice;
    private Stage stage;
    private Scene scene;
    private Parent root;
    Double totalPriceValue = 0.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        receiptTable.getColumns().addAll(productId, productName, quantity, price);
        productId.setCellValueFactory(new PropertyValueFactory<CartProduct, String>("id"));
        productName.setCellValueFactory(new PropertyValueFactory<CartProduct, String>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<CartProduct, String>("quantity"));
        price.setCellValueFactory(new PropertyValueFactory<CartProduct, String>("price"));

        receiptTable.setItems(cartProductsList);

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

