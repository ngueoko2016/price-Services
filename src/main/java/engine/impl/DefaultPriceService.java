package engine.impl;

import actions.Action;

import conditions.Condition;
import domain.Order;
import engine.PriceService;

import java.util.Map;

public class DefaultPriceService implements PriceService {

    private final Map<Condition<Order>, Action<Order>> rulesContext ;

    public DefaultPriceService(Map<Condition<Order>, Action<Order>> rulesContext) {
        this.rulesContext = rulesContext;
    }

    @Override
    public void calculate(final Order order) {
        this.applyPriceRules(order);
        this.calculateValues(order);
    }

    private void applyPriceRules(Order order) {
        order.setTatalPrice(order.getTotalQuantity()*order.getProduct().getPrice());
        rulesContext.forEach((orderSpecification, orderAction) -> {
            if (orderSpecification.isSatisfiedBy(order))
                orderAction.execute(order);
        });
    }

    private void calculateValues(Order order) {
        double totalPrice=order.getTatalPrice();
        order.setTatalPrice(totalPrice - order.getDiscount());
        int quantity=order.getTotalQuantity();
        order.setTotalQuantity(quantity+order.getRewardingQuantity());
    }
}
