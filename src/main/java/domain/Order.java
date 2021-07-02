package domain;

public class Order {
    private Product product;
    private int totalQuantity;
    private int rewardingQuantity;
    private double tatalPrice;
    private double discount;

    public Order(Product product, int totalQuantity) {
        this.product = product;
        this.totalQuantity = totalQuantity;
    }

    public double getTatalPrice() {
        return tatalPrice;
    }

    public void setTatalPrice(double tatalPrice) {
        this.tatalPrice = tatalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getRewardingQuantity() {
        return rewardingQuantity;
    }

    public void setRewardingQuantity(int rewardingQuantity) {
        this.rewardingQuantity = rewardingQuantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product=" + product +
                ", totalQuantity=" + totalQuantity +
                ", rewardingQuantity=" + rewardingQuantity +
                ", tatalPrice=" + tatalPrice +
                ", discount=" + discount +
                '}';
    }
}
