package data;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CartProduct {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty quantity;
    private final SimpleDoubleProperty actualPrice;
    private final SimpleIntegerProperty discount;
    private final SimpleDoubleProperty priceAfterDiscount;

    public CartProduct(int id, String name, int quantity, double actualPrice, int discount, double priceAfterDiscount) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.actualPrice = new SimpleDoubleProperty(actualPrice);
        this.discount = new SimpleIntegerProperty(discount);
        this.priceAfterDiscount = new SimpleDoubleProperty(priceAfterDiscount);
    }


    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public int getQuantity() {
        return quantity.get();
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public double getActualPrice() {
        return actualPrice.get();
    }

    public SimpleDoubleProperty actualPriceProperty() {
        return actualPrice;
    }

    public int getDiscount() {
        return discount.get();
    }

    public SimpleIntegerProperty discountProperty() {
        return discount;
    }

    public double getPriceAfterDiscount() {
        return priceAfterDiscount.get();
    }

    public SimpleDoubleProperty priceAfterDiscountProperty() {
        return priceAfterDiscount;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice.set(actualPrice);
    }

    public void setDiscount(int discount) {
        this.discount.set(discount);
    }

    public void setPriceAfterDiscount(double priceAfterDiscount) {
        this.priceAfterDiscount.set(priceAfterDiscount);
    }
}
