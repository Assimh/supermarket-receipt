package esiea.model;

import org.junit.jupiter.api.Test;
import esiea.*;
import org.assertj.core.api.Assertions;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {

 @Test
public void getItems() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apples = new Product("apples", ProductUnit.Kilo);
        shoppingCart.addItemQuantity(apples, 2.0);
        ArrayList<Product> toast = new ArrayList(shoppingCart.getItems());
        toast.add(apples);
        Assertions.assertThat(shoppingCart.getItems()).isEqualTo(toast);
        
}

}