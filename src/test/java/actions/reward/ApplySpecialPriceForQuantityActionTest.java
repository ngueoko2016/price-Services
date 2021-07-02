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
        applySpecialPriceForQuantityAction= new ApplySpecialPriceForQuantityAction(1,3);
    }

    @Test
    public void shouldReturnOneDollarForTheThreeProducts() {
        Order order= new Order(new Product(),3);
        applySpecialPriceForQuantityAction.execute(order);
        Assert.assertThat(order.getTatalPrice(), is(1.00));
    }
    @Test
    public void shouldReturnTwoPointHeightDollarWhenTwoProducts() {
        Order order= new Order(new Product(1.4),2);
        applySpecialPriceForQuantityAction.execute(order);
        Assert.assertThat(order.getTatalPrice(), is(2.8));
    }

    @Test
    public void shouldReturnTwoPointFourDollarWhenFourProducts() {
        Product product = new Product(1.4);
        Order order= new Order(product,4);
        applySpecialPriceForQuantityAction.execute(order);
        Assert.assertThat(order.getTatalPrice(), is(2.4));
    }

    @Test
    public void shouldReturnTwoDollarWhenSixProducts() {
        Product product = new Product(1.4);
        Order order= new Order(product,6);
        applySpecialPriceForQuantityAction.execute(order);
        Assert.assertThat(order.getTatalPrice(), is(2.00));
    }
}
