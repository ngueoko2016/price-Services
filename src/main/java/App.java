import domain.Order;
import domain.Product;
import domain.enums.ProductType;
import engine.PriceRulesContext;
import engine.PriceService;
import engine.impl.DefaultPriceService;

public class App {
    public static void main(String[] args) {
        PriceService priceService= new DefaultPriceService(PriceRulesContext.getRulesContext());

        // Buying 2 quantity of TYPE_ONE at 1.4.
        Product myProduct1 = new Product(ProductType.TYPE_ONE,1.4);
        Order myOrder1= new Order(myProduct1,2);
        priceService.calculate(myOrder1);

        // Buying 7 quantity of TYPE_ONE at 1.8.
        Product myProduct2 = new Product(ProductType.TYPE_TWO,2.8);
        Order myOrder2= new Order(myProduct2,7);
        priceService.calculate(myOrder2);

        display(myOrder1);
        display(myOrder2);

    }

    private static void display(Order myOrder1) {
        System.out.println(myOrder1);
    }
}
