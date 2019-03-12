package ch.heigvd.res.pizza.domain.adrienbarth;

import ch.heigvd.res.pizza.domain.Pizzaiolo;
import ch.heigvd.res.pizza.protocol.OrderRequest;
import ch.heigvd.res.pizza.protocol.OrderResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardamoneTest {

    @Test
    void thePriceAndNameForCardamoneShouldBeCorrect() {
        Cardamone beer = new Cardamone();
        assertEquals(beer.getName(), Cardamone.NAME);
        assertEquals(beer.getPrice(), Cardamone.PRICE);
    }

    @Test
    void aPizzaioloShouldAcceptAnOrderForCardamone() {
        Pizzaiolo mario = new Pizzaiolo();
        String productName = "ch.heigvd.res.pizza.domain.adrienbarth.Cardamone";
        int numberOfPizzas = 2;
        OrderRequest request = new OrderRequest(numberOfPizzas, productName);
        OrderResponse response = mario.order(request);
        BigDecimal expectedTotalPrice = Cardamone.PRICE.multiply(new BigDecimal(numberOfPizzas));
        assertEquals(expectedTotalPrice, response.getTotalPrice());
    }

}