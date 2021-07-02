package actions.reward;


import domain.Order;
import domain.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
public class RewardQuantityForQuantityActionTest {

    RewardQuantityForQuantityAction rewardQuantityForQuantityAction;
    @Before
    public void setUp() {
        rewardQuantityForQuantityAction= new RewardQuantityForQuantityAction(1,2);
    }

    @Test
    public void shouldReturnOneWhenQuantityEqualsTwo() {
        Order order= new Order(new Product(),2);
        rewardQuantityForQuantityAction.execute(order);
        Assert.assertThat(order.getRewardingQuantity(), is(1));
    }

    @Test
    public void shouldReturnZeroWhenQuantityLeastThan2() {
        Order order= new Order(new Product(),1);
        rewardQuantityForQuantityAction.execute(order);
        Assert.assertThat(order.getRewardingQuantity(), is(0));
    }

    @Test
    public void shouldReturnTwoWhenQuantityEqualsFour() {
        Order order= new Order(new Product(),4);
        rewardQuantityForQuantityAction.execute(order);
        Assert.assertThat(order.getRewardingQuantity(), is(2));
    }

    @Test
    public void shouldReturnTwoWhenQuantityEqualsFive() {
        Order order= new Order(new Product(),5);
        rewardQuantityForQuantityAction.execute(order);
        Assert.assertThat(order.getRewardingQuantity(), is(2));
    }

    @Test
    public void shouldReturnThreeWhenQuantityEqualsSeven() {
        Order order= new Order(new Product(),7);
        rewardQuantityForQuantityAction.execute(order);
        Assert.assertThat(order.getRewardingQuantity(), is(3));
    }
}
