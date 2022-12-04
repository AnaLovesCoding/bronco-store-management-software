package data;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class ShopProduct {

    private final SimpleLongProperty id;
    private final SimpleStringProperty name;
    private final SimpleLongProperty price;
    private ComboBox quantityComboBox;

    public ShopProduct(Long id, String name, Long price, ObservableList<Integer> quantityList) {
        ComboBox comboBox = new ComboBox(quantityList);
        comboBox.getSelectionModel().select(0);

        this.id = new SimpleLongProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleLongProperty(price);
        this.quantityComboBox = comboBox;
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

    public ComboBox getQuantityComboBox() {
        return quantityComboBox;
    }

    public void setQuantityComboBox(ComboBox quantity) {
        this.quantityComboBox = quantity;
    }
}
