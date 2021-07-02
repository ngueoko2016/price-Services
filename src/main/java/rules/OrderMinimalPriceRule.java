package rules;

import conditions.AbstractCondition;
import domain.Order;
/**
 * Is the price of our purchase above a certain amount?
*/
public class OrderMinimalPriceRule extends AbstractCondition<Order> {
    private double minPrice;

    public OrderMinimalPriceRule(double minPrice) {
        this.minPrice = minPrice;
    }

    @Override
    public boolean isSatisfiedBy(Order candidate) {
        return candidate.getTatalPrice()>=minPrice;
    }

    @Override
    public String toString() {
        return "OrderMinimalPriceRule{" +
                "minPrice=" + minPrice +
                '}';
    }
}
