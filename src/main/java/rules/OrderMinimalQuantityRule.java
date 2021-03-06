package rules;

import conditions.AbstractCondition;
import domain.Order;
/**
 *  Is the quantity of our purchase greater than a certain quantity ?
*/
public class OrderMinimalQuantityRule extends AbstractCondition<Order> {
    private  int minQuantity;

    public OrderMinimalQuantityRule(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    @Override
    public boolean isSatisfiedBy(Order candidate) {
        return candidate.getTotalQuantity()>=minQuantity;
    }

    @Override
    public String toString() {
        return "OrderMinimalQuantityRule{" +
                "minQuantity=" + minQuantity +
                '}';
    }
}
