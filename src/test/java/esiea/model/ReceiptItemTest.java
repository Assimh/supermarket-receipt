package esiea.model;

import org.junit.jupiter.api.Test;
import esiea.ReceiptPrinter;
import org.assertj.core.api.Assertions;
import java.util.ArrayList;
import java.util.List;

public class ReceiptItemTest {

 @Test
    public void GetPriceTest() {
        Product apples = new Product("apples", ProductUnit.Kilo);
        ReceiptItem receiptItem = new ReceiptItem(apples,2.0,1.99, 3.98);
        Assertions.assertThat(receiptItem.getPrice()).isEqualTo(1.99);
    }

    @Test
    public void GetProductTest(){
        Product apples = new Product("apples", ProductUnit.Kilo);
        ReceiptItem receiptItem = new ReceiptItem(apples,2.0,1.99, 3.98);
        Assertions.assertThat(receiptItem.getProduct()).isEqualTo(apples);
    }

    @Test
    public void GetQuantityTest(){
        Product apples = new Product("apples", ProductUnit.Kilo);
        ReceiptItem receiptItem = new ReceiptItem(apples,2.0,1.99, 3.98);
        Assertions.assertThat(receiptItem.getQuantity()).isEqualTo(2.0);
    }

    @Test
    public void GetTotalPriceTest(){
        Product apples = new Product("apples", ProductUnit.Kilo);
        ReceiptItem receiptItem = new ReceiptItem(apples,2.0,1.99, 3.98);
        Assertions.assertThat(receiptItem.getTotalPrice()).isEqualTo(3.98);
    }

    @Test
    public void ReceiptGetItemsTest(){
        SupermarketCatalog catalog = new FakeCatalog();
        ShoppingCart cart = new ShoppingCart();

        Teller teller = new Teller(catalog);
        Receipt receipt = teller.checksOutArticlesFrom(cart);

        List<ReceiptItem> expectedList = new ArrayList();
        Assertions.assertThat(receipt.getItems()).isEqualTo(expectedList);
    }
}
