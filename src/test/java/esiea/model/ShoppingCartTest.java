package esiea.model;

import org.junit.jupiter.api.Test;
import esiea.*;
import org.assertj.core.api.Assertions;
import java.util.*;
public class ShoppingCartTest {

@Test
public void getItems() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apples = new Product("apples", ProductUnit.Kilo);
        shoppingCart.addItemQuantity(apples, 2.0);
        ArrayList<ProductQuantity> toast = new ArrayList(shoppingCart.getItems());
        Iterator classIterator = shoppingCart.getItems().iterator();
        for(ProductQuantity x : toast)
        {
                Assertions.assertThat(classIterator.next()).isEqualTo(x);
        }   
}
@Test
public void handleOffersTwoForAmountTest()
{
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apples = new Product("apples", ProductUnit.Kilo);
        shoppingCart.addItemQuantity(apples, 4.0);
        Map<Product, Offer> offers = new HashMap<>();
        Offer offer = new Offer(SpecialOfferType.TwoForAmount, apples, 6.0);
        offers.put(apples, offer);
        Receipt receipt = new Receipt();
        SupermarketCatalog catalog = new FakeCatalog();
        catalog.addProduct(apples, 5.0);
        shoppingCart.handleOffers(receipt, offers, catalog);
        for(Discount x : receipt.getDiscounts())
        {
                Assertions.assertThat(x.getDiscountAmount()).isEqualTo(8.0);
        }
}

@Test
public void handleOffersTwoForAmountLowQuantityTest()
{
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apples = new Product("apples", ProductUnit.Kilo);
        shoppingCart.addItemQuantity(apples, 1.0);
        Map<Product, Offer> offers = new HashMap<>();
        Offer offer = new Offer(SpecialOfferType.TwoForAmount, apples, 6.0);
        offers.put(apples, offer);
        Receipt receipt = new Receipt();
        SupermarketCatalog catalog = new FakeCatalog();
        catalog.addProduct(apples, 5.0);
        shoppingCart.handleOffers(receipt, offers, catalog);
        Assertions.assertThat(receipt.getDiscounts().size()).isEqualTo(0);
}
@Test
public void handleOffersThreeForTwoTest()
{
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apples = new Product("apples", ProductUnit.Kilo);
        shoppingCart.addItemQuantity(apples, 6.0);
        Map<Product, Offer> offers = new HashMap<>();
        Offer offer = new Offer(SpecialOfferType.ThreeForTwo, apples, 6.0);
        offers.put(apples, offer);
        Receipt receipt = new Receipt();
        SupermarketCatalog catalog = new FakeCatalog();
        catalog.addProduct(apples, 5.0);
        shoppingCart.handleOffers(receipt, offers, catalog);
        for(Discount x : receipt.getDiscounts())
        {
                Assertions.assertThat(x.getDiscountAmount()).isEqualTo(10.0);
        }
}
@Test
public void handleOffersThreeForTwoLowQuantityTest()
{
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apples = new Product("apples", ProductUnit.Kilo);
        shoppingCart.addItemQuantity(apples, 2.0);
        Map<Product, Offer> offers = new HashMap<>();
        Offer offer = new Offer(SpecialOfferType.ThreeForTwo, apples, 6.0);
        offers.put(apples, offer);
        Receipt receipt = new Receipt();
        SupermarketCatalog catalog = new FakeCatalog();
        catalog.addProduct(apples, 5.0);
        shoppingCart.handleOffers(receipt, offers, catalog);
        Assertions.assertThat(receipt.getDiscounts().size()).isEqualTo(0);
}


@Test
public void handleOffersFiveForAmountTwoTest()
{
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apples = new Product("apples", ProductUnit.Kilo);
        shoppingCart.addItemQuantity(apples, 10.0);
        Map<Product, Offer> offers = new HashMap<>();
        Offer offer = new Offer(SpecialOfferType.FiveForAmount, apples, 6.0);
        offers.put(apples, offer);
        Receipt receipt = new Receipt();
        SupermarketCatalog catalog = new FakeCatalog();
        catalog.addProduct(apples, 5.0);
        shoppingCart.handleOffers(receipt, offers, catalog);
        for(Discount x : receipt.getDiscounts())
        {
                Assertions.assertThat(x.getDiscountAmount()).isEqualTo(38.0);
        }
}
@Test
public void handleOffersNullTest()
{
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apples = new Product("apples", ProductUnit.Kilo);
        shoppingCart.addItemQuantity(apples, 1.0);
        Map<Product, Offer> offers = new HashMap<>();
        Offer offer = new Offer(SpecialOfferType.FiveForAmount, apples, 6.0);
        offers.put(apples, offer);
        Receipt receipt = new Receipt();
        SupermarketCatalog catalog = new FakeCatalog();
        catalog.addProduct(apples, 5.0);
        shoppingCart.handleOffers(receipt, offers, catalog);
        Assertions.assertThat(receipt.getDiscounts().size()).isEqualTo(0);
}
}