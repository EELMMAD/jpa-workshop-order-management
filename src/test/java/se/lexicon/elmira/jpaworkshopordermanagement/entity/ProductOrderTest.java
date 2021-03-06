package se.lexicon.elmira.jpaworkshopordermanagement.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductOrderTest {
    Product product, product1;
    OrderItem orderItem, orderItem1;
    ProductOrder productOrder;

    @BeforeEach
    void setUp() {
        product = new Product("T-shirt", 100);
        product1 = new Product("Network Cable 1m", 150);
        orderItem = new OrderItem(5, product, null);
        orderItem1 = new OrderItem(2, product1, null);
        productOrder = new ProductOrder(LocalDateTime.now(), Arrays.asList(orderItem, orderItem1), null);

        List<OrderItem> orderItems = new ArrayList();
        orderItems.add(orderItem);
        orderItems.add(orderItem1);
        productOrder = new ProductOrder(LocalDateTime.now(), orderItems, null);

    }

    @Test
    void addOrderItem() {
        //Arrange
        OrderItem ipad = new OrderItem(1, new Product("Ipad", 4000), null);

        //Act
        boolean successfullyAdded = productOrder.addOrderItem(ipad);

        //Assert
        assertTrue(successfullyAdded);
        assertNotNull(ipad.getProductOrder());
        assertTrue(productOrder.getOrderItems().contains(ipad));
    }

    @Test
    void removeOrderItems() {
    }

    @Test
    void calculateOrderPrice() {
        
        //Arrange
        double expected = 800;

        //Act
        double actual = productOrder.calculateOrderPrice();
        
        //Assert
        assertEquals(expected, actual);
    }
}