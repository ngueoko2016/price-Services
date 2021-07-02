package actions.reward;

import actions.Action;
import domain.Order;
/**
 * Sel a specific quantity at the specific price. Ex. One cost $1.4, but Three cost $1
 * */
public class ApplySpecialPriceForQuantityAction implements Action<Order> {
    private  double specialPrice;
    private int magicQuantity;

    public ApplySpecialPriceForQuantityAction(double specialPrice, int magicQuantity) {
        this.specialPrice = specialPrice;
        this.magicQuantity = magicQuantity;
    }

    @Override
    public void execute(Order candidte) {
        int quantity= candidte.getTotalQuantity();
        double totalPrice= specialPrice*(quantity/this.magicQuantity)+(quantity%this.magicQuantity)*candidte.getProduct().getPrice();
        candidte.setTatalPrice(totalPrice);
    }
}
