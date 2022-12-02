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
import remoteapi.product.Product;
import remoteapi.product.ProductsApi;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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


        ProductsApi productsApi = new ProductsApi();
        productsApi.setOnSucceeded(event -> {
            Product[] products = productsApi.getValue();
            ArrayList<ShopProduct> productArrayList = new ArrayList<>();

            for (int i = 0; i < products.length; i++) {
                Product product = products[i];
                productArrayList.add(
                        new ShopProduct(
                                product.getProductId(),
                                product.getName(),
                                product.getCurrentPrice(),
                                FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                        )
                );
            }

            tableData = FXCollections.observableArrayList(productArrayList);
            shopTable.setItems(tableData);
        });
        new Thread(productsApi).start();


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

