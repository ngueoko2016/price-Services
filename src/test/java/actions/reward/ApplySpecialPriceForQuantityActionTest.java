package actions.reward;

import domain.Order;
import domain.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class ApplySpecialPriceForQuantityActionTest {

    ApplySpecialPriceForQuantityAction applySpecialPriceForQuantityAction;
    @Before
    public void setUp() {
        applySpecialPriceForQuantityAction= new ApplySpecialPriceForQuantityAction(1,2);
    }

    @Test
    public void shouldReturnOneDollarForTheThreeProducts() {
        Order order= new Order(new Product(),3);
        applySpecialPriceForQuantityAction.execute(order);
        Assert.assertThat(order.getTatalPrice(), is(1.00));
    }

}
