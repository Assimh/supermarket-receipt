package esiea.model;

import org.junit.jupiter.api.Test;
import esiea.ReceiptPrinter;
import org.assertj.core.api.Assertions;

public class ReceiptPrinterTest {

   //Test ReceiptPrinter
   @Test
   public void testReceiptPrinter() {
      SupermarketCatalog catalog = new FakeCatalog();
      Product apples = new Product("apples", ProductUnit.Kilo);
      catalog.addProduct(apples, 1.99);

      ShoppingCart cart = new ShoppingCart();
      cart.addItemQuantity(apples, 2);

      Teller teller = new Teller(catalog);
       
      Receipt receipt = teller.checksOutArticlesFrom(cart);
      ReceiptPrinter receiptprinter = new ReceiptPrinter();
      Assertions.assertThat(receiptprinter.printReceipt(receipt)).isNotBlank();
   }
}