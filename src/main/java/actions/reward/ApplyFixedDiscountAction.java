package actions.reward;

import actions.Action;
import domain.Order;
/**
 * Apply fixed discount. Ex $2 dollars discount
 * */
public class ApplyFixedDiscountAction implements Action<Order> {
    private double fixedDiscount;

    public ApplyFixedDiscountAction(double fixedDiscount) {
        this.fixedDiscount = fixedDiscount;
    }

    @Override
    public void execute(Order candidte) {
        candidte.setDiscount(candidte.getDiscount()+this.fixedDiscount);
    }
}
