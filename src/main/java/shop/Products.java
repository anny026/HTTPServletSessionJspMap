package shop;

import java.util.Objects;

public class Products {
    private String product;
    private int id;
    private int price;
    public Products(){
    };

    public Products(String product, int price) {
        this.product = product;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  product + "(" + price +" $ ) " ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products products)) return false;
        return getPrice() == products.getPrice() && Objects.equals(getProduct(), products.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct(), getPrice());
    }
}
