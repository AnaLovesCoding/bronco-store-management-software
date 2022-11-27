package presentation;

import data.ShopProduct;
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

public class shopController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    ObservableList<ShopProduct> tableData;

    @FXML
    private TableView shopTable;

    @FXML
    private TableColumn id, name, price, quantity;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shopTable.getColumns().addAll(id, name, price, quantity);
        id.setCellValueFactory(new PropertyValueFactory<ShopProduct, String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<ShopProduct, String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<ShopProduct, String>("price"));
        quantity.setCellValueFactory(new PropertyValueFactory<ShopProduct, String>("quantity"));


        tableData = FXCollections.observableArrayList(
                new ShopProduct(0, "Soap", 50.0,
                        FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                ),
                new ShopProduct(1, "Nicker", 35.0,
                        FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                )
        );
        shopTable.setItems(tableData);
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
    protected void switchToViewCart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("cart.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

