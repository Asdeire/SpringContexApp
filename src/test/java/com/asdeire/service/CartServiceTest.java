import com.asdeire.model.Cart;
import com.asdeire.model.Product;
import com.asdeire.service.CartService;
import com.asdeire.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CartServiceTest {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    private Cart cart;

    @BeforeEach
    public void setup() {
        cart = cartService.getNewCart();
    }

    @Test
    public void testAddProductToCart() {
        Product product = productService.getProductById(1L);
        cartService.addProduct(cart, product, 2);

        assertEquals(2, cartService.getProductQuantity(cart, product));
        assertEquals(new BigDecimal("200.00"), cartService.getSum(cart));
    }

    @Test
    public void testDelProductFromCart() {
        Product product = productService.getProductById(1L);
        cartService.addProduct(cart, product, 2);
        cartService.delProduct(cart, product, 1);

        assertEquals(1, cartService.getProductQuantity(cart, product));
    }

    @Test
    public void testCartSum() {
        Product product1 = productService.getProductById(1L);
        Product product2 = productService.getProductById(2L);

        cartService.addProduct(cart, product1, 1);
        cartService.addProduct(cart, product2, 1);

        assertEquals(new BigDecimal("250.00"), cartService.getSum(cart));
    }
}
