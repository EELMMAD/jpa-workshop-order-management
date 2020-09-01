package se.lexicon.elmira.jpaworkshopordermanagement.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.elmira.jpaworkshopordermanagement.entity.OrderItem;
import se.lexicon.elmira.jpaworkshopordermanagement.entity.Product;
import se.lexicon.elmira.jpaworkshopordermanagement.entity.ProductOrder;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderItemRepositoryTest {
    OrderItem testObject;

    @Autowired
    OrderItemRepository orderItemRepository;

    @BeforeEach
    void setUp() {
        Product car = new Product( "Car", 1_000_000);
        testObject = orderItemRepository.save(new OrderItem(2, car, null));
    }

    //Dose save() is working?
    @Test
    void SuccessfullyCreated() {
        List<OrderItem> found = orderItemRepository.findAll();

        assertFalse(found.isEmpty());
        assertTrue(found.contains(testObject));
    }
}