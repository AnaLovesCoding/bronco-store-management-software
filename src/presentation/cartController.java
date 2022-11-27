package presentation;

import data.CartProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class cartController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    ObservableList<CartProduct> tableData;

    @FXML
    private TableView cartTable;

    @FXML
    private TableColumn id, name, actualPrice, discount, priceAfterDiscount, quantity;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cartTable.getColumns().addAll(id, name, quantity, actualPrice, discount, priceAfterDiscount);
        id.setCellValueFactory(new PropertyValueFactory<CartProduct, String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<CartProduct, String>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<CartProduct, String>("quantity"));
        actualPrice.setCellValueFactory(new PropertyValueFactory<CartProduct, String>("actualPrice"));
        discount.setCellValueFactory(new PropertyValueFactory<CartProduct, String>("discount"));
        priceAfterDiscount.setCellValueFactory(new PropertyValueFactory<CartProduct, String>("priceAfterDiscount"));

        tableData = FXCollections.observableArrayList(new CartProduct(0, "book", 1, 3.0, 1, 2.0));
        cartTable.setItems(tableData);

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

}

