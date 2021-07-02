package engine.impl;



import domain.Order;
import domain.Product;
import domain.enums.ProductType;
import engine.PriceRulesContext;
import engine.PriceService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class DefaultPriceServiceTest {
    PriceService priceService;
    @Before
    public void setUp() throws Exception {
        priceService= new DefaultPriceService(PriceRulesContext.getRulesContext());
    }
    @Test
    public void shouldReturnNormalPrice() {
        Product product = new Product(ProductType.TYPE_ONE,1.4);
        Order order= new Order(product,2);
        priceService.calculate(order);
        Assert.assertThat(order.getTatalPrice(), is(2.8));
    }
    @Test
    public void shouldAddOneForFreeWhenTypeOne() {
        Product product = new Product(ProductType.TYPE_ONE,1.4);
        Order order= new Order(product,2);
        priceService.calculate(order);
        Assert.assertEquals(order.getTotalQuantity(),3);
        Assert.assertThat(order.getTatalPrice(), is(2.8));
    }

    @Test
    public void shouldApplySpecialOneDollarForTheThreeProducts() {
        Product product = new Product(ProductType.TYPE_TWO,1.4);
        Order order= new Order(product,3);
        priceService.calculate(order);
        Assert.assertThat(order.getTatalPrice(), is(1.00));
        Assert.assertThat(order.getTotalQuantity(), is(3));
    }

    @Test
    public void shouldApplySpecialOneDollarForTheFirstsThreeProducts() {
        Product product = new Product(ProductType.TYPE_TWO,1.4);
        Order order= new Order(product,4);
        priceService.calculate(order);
        Assert.assertThat(order.getTatalPrice(), is(2.4));
        Assert.assertThat(order.getTotalQuantity(), is(4));
    }

    @Test
    public void shouldApplyFixed2DollarsDiscount() {
        Product product = new Product(ProductType.TYPE_TWO,5);
        Order order= new Order(product,2);
        priceService.calculate(order);
        Assert.assertThat(order.getTatalPrice(), is(8.0));
        Assert.assertThat(order.getTotalQuantity(), is(2));
    }

    @Test
    public void shouldRewardOneAndApplyFixed2DollarsDiscount() {
        Product product = new Product(ProductType.TYPE_ONE,5);
        Order order= new Order(product,2);
        priceService.calculate(order);
        Assert.assertThat(order.getTatalPrice(), is(8.0));
        Assert.assertThat(order.getTotalQuantity(), is(4));
    }
}
