package domain;


import domain.enums.ProductType;

public class Product {
    private ProductType productType;
    private double price;
    public Product(ProductType productType, double price) {
        this.productType=productType;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productType=" + productType +
                ", price=" + price +
                '}';
    }
}
