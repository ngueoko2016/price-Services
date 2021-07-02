package actions.reward;


import domain.Order;
import domain.Product;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class ApplyFixedDiscountActionTest {
    ApplyFixedDiscountAction applyFixedDiscountAction;

    @Test
    public void shouldApplyTwoDollarsFixedDiscount() {
        applyFixedDiscountAction= new ApplyFixedDiscountAction(2.00);
        Order order= new Order(new Product(),4);
        applyFixedDiscountAction.execute(order);
        Assert.assertThat(order.getDiscount(), is(2.00));
    }
    @Test
    public void shouldNotApplyTwoDollarsFixedDiscountWhenNoDiscount() {
        applyFixedDiscountAction= new ApplyFixedDiscountAction(0.00);
        Order order= new Order(new Product(),1000);
        applyFixedDiscountAction.execute(order);
        Assert.assertThat(order.getDiscount(), is(0.00));
    }
}
