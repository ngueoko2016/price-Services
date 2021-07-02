package engine;


import domain.Order;

public interface PriceService {
    void calculate(Order order);
}
