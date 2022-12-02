package data;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class ShopProduct {

    private final SimpleLongProperty id;
    private final SimpleStringProperty name;
    private final SimpleLongProperty price;
    private ComboBox quantity;

    public ShopProduct(Long id, String name, Long price, ObservableList<Integer> quantityList) {
        ComboBox quantityComboBox = new ComboBox(quantityList);
        quantityComboBox.getSelectionModel().select(0);

        this.id = new SimpleLongProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleLongProperty(price);
        this.quantity = quantityComboBox;
    }

    public Long getId() {
        return id.get();
    }

    public void setId(Long id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Long getPrice() {
        return price.get();
    }

    public void setPrice(Long price) {
        this.price.set(price);
    }

    public ComboBox getQuantity() {
        return quantity;
    }

    public void setQuantity(ComboBox quantity) {
        this.quantity = quantity;
    }
}
