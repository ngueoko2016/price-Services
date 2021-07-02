package actions.reward;

import actions.Action;
import domain.Order;

public class ApplySpecialPriceForQuantityAction implements Action<Order> {
    private  double specialPrice;
    private int magicQuantity;

    public ApplySpecialPriceForQuantityAction(double specialPrice, int magicQuantity) {
        this.specialPrice = specialPrice;
        this.magicQuantity = magicQuantity;
    }

    @Override
    public void execute(Order candidte) {
        candidte.setTatalPrice(1.00);
    }
}
