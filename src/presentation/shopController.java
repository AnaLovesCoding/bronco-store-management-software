package presentation;

import data.CartProduct;
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
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import remoteapi.product.FetchProductsApi;
import remoteapi.product.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static data.CartData.cartProductsList;

public class shopController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    ObservableList<ShopProduct> tableData;

    @FXML
    private TableView shopTable;

    @FXML
    private TableColumn id, name, price, quantityComboBox;

    @FXML
    private ProgressIndicator progressBar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shopTable.getColumns().addAll(id, name, price, quantityComboBox);
        id.setCellValueFactory(new PropertyValueFactory<ShopProduct, String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<ShopProduct, String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<ShopProduct, String>("price"));
        quantityComboBox.setCellValueFactory(new PropertyValueFactory<ShopProduct, String>("quantityComboBox"));


        FetchProductsApi fetchProductsApi = new FetchProductsApi();

        fetchProductsApi.setOnSucceeded(event -> {
            handleProductsResult(fetchProductsApi.getValue());
        });
        new Thread(fetchProductsApi).start();
    }

    private void handleProductsResult(Product[] products) {
        progressBar.setVisible(false);

        ArrayList<ShopProduct> productArrayList = new ArrayList<>();

        for (Product product : products) {
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

        ObservableList<ShopProduct> finalData = tableData.filtered(shopProduct -> shopProduct
                .getQuantityComboBox()
                .getSelectionModel()
                .getSelectedIndex() > 0
        );

        cartProductsList.clear();

        finalData.forEach(shopProduct -> {
            String quantityString = shopProduct.getQuantityComboBox()
                    .getSelectionModel()
                    .getSelectedItem()
                    .toString();
            int quantity = Integer.parseInt(quantityString);
            cartProductsList.add(
                    new CartProduct(
                            shopProduct.getId(),
                            shopProduct.getName(),
                            quantityString,
                            shopProduct.getPrice() * quantity
                    )
            );
        });

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

