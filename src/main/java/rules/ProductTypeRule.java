package rules;


import conditions.AbstractCondition;
import domain.Order;
import domain.enums.ProductType;
/**
 * Is our product of a certain type?
 */
public class ProductTypeRule extends AbstractCondition<Order> {
    private ProductType productType;

    public ProductTypeRule(ProductType productType) {
        this.productType = productType;
    }
    @Override
    public boolean isSatisfiedBy(Order candidate) {
        return productType.equals(candidate.getProduct().getProductType());
    }

    @Override
    public String toString() {
        return "ProductTypeRule{" +
                "productType=" + productType +
                '}';
    }
}
