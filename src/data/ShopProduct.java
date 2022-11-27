package data;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class ShopProduct {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleDoubleProperty price;
    private ComboBox quantity;

    public ShopProduct(int id, String name, Double price, ObservableList<Integer> quantityList) {
        ComboBox quantityComboBox = new ComboBox(quantityList);
        quantityComboBox.getSelectionModel().select(0);

        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.quantity = quantityComboBox;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public ComboBox getQuantity() {
        return quantity;
    }

    public void setQuantity(ComboBox quantity) {
        this.quantity = quantity;
    }
}
