package se.lexicon.elmira.jpaworkshopordermanagement.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.elmira.jpaworkshopordermanagement.entity.AppUser;
import se.lexicon.elmira.jpaworkshopordermanagement.entity.OrderItem;
import se.lexicon.elmira.jpaworkshopordermanagement.entity.Product;
import se.lexicon.elmira.jpaworkshopordermanagement.entity.ProductOrder;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductOrderRepositoryTest {

    @Autowired
    ProductOrderRepository productOrderRepository;
    ProductOrder testObject;

    @BeforeEach
    void setUp() {
        AppUser testUser = new AppUser("Test", "Testsson", "test@test.se");
        Product testProduct = new Product("Book", 150);
        OrderItem testOrderItem = new OrderItem(2, testProduct, null);
        testObject = new ProductOrder(LocalDateTime.of(2020, Month.JANUARY, 1, 13, 30), null, testUser);
        testObject.addOrderItem(testOrderItem);
        testObject = productOrderRepository.save(testObject);
    }

    @Test
    void successfullyCreated() {
        Optional<ProductOrder> found = productOrderRepository.findById(testObject.getId());

        assertTrue(found.isPresent());
        assertEquals(found.get(), testObject);

        assertNotNull(found.get().getOrderItems());
        assertNotNull(found.get().getOrderItems().get(0).getProductOrder());
    }

    @Test
    void findAllByOrderDateTimeBetween() {
    }

    @Test
    void findByOrderItems_Product_Id() {
    }

    @Test
    void findAllByOrderItems_Product_name() {
    }

    @Test
    void findAllByCustomer_Id() {
    }
}