package data;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class CartProduct {
    private final SimpleLongProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty quantity;
    private final SimpleLongProperty price;

    public CartProduct(Long id, String name, String quantity, Long price) {
        this.id = new SimpleLongProperty(id);
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleStringProperty(quantity);
        this.price = new SimpleLongProperty(price);
    }

    public Long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getQuantity() {
        return quantity.get();
    }

    public SimpleStringProperty quantityProperty() {
        return quantity;
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleLongProperty priceProperty() {
        return price;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    public void setPrice(Long price) {
        this.price.set(price);
    }
}
