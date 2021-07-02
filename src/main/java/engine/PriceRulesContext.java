package engine;

import actions.Action;

import actions.reward.ApplyFixedDiscountAction;
import actions.reward.ApplySpecialPriceForQuantityAction;
import actions.reward.RewardQuantityForQuantityAction;
import conditions.AbstractCondition;
import conditions.AndCondition;
import conditions.Condition;
import domain.Order;
import domain.enums.ProductType;
import rules.OrderMinimalPriceRule;
import rules.OrderMinimalQuantityRule;
import rules.ProductTypeRule;

import java.util.HashMap;
import java.util.Map;

public class PriceRulesContext {

    public static Map<Condition<Order>, Action<Order>> getRulesContext(){
         Map<Condition<Order>, Action<Order>> specificationSetMap = new HashMap<Condition<Order>, Action<Order>>();
        // Config A. Buy two TYPE_ONE product, get one free reward
        AbstractCondition<Order> buyTwoGetOneFreeCondition = new AndCondition<Order>(new ProductTypeRule(ProductType.TYPE_ONE),new OrderMinimalQuantityRule(2));
        Action<Order> addRewardQuantityForMinQuantityAction = new RewardQuantityForQuantityAction(1,1);
        specificationSetMap.put(buyTwoGetOneFreeCondition, addRewardQuantityForMinQuantityAction);

        // Config B. Buy three TYPE_TWO product at $1 dollar
        AbstractCondition<Order> buyThreeToOneDollarCondition = new AndCondition<Order>(new ProductTypeRule(ProductType.TYPE_TWO),new OrderMinimalQuantityRule(3));
        Action<Order> threeToOneDollarAction = new ApplySpecialPriceForQuantityAction(1.00, 3);
        specificationSetMap.put(buyThreeToOneDollarCondition, threeToOneDollarAction);

        //Config C. Apply 2 dollars fixed discount when total price greater than $10
        AbstractCondition<Order> fixedDiscountCondition = new OrderMinimalPriceRule(10);
        Action<Order> applyFixedDiscount = new ApplyFixedDiscountAction(2);
        specificationSetMap.put(fixedDiscountCondition, applyFixedDiscount);

        return specificationSetMap;
    }
}
