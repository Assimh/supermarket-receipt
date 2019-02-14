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

   //Test Receipt printer Form
   @Test
   public void testReceiptPrinterForm(){
      SupermarketCatalog catalog = new FakeCatalog();

      //Produit avec Discount
      Product apples = new Product("apples", ProductUnit.Kilo);
      catalog.addProduct(apples, 1.5);

      //2 Produits
      Product orange = new Product("orange", ProductUnit.Kilo);
      catalog.addProduct(orange, 1.99);

      ShoppingCart cart = new ShoppingCart();
      cart.addItemQuantity(apples, 2);
      cart.addItemQuantity(orange, 2);

      Teller teller = new Teller(catalog);
      teller.addSpecialOffer(SpecialOfferType.TwoForAmount, orange, 1.99);

      Receipt receipt = teller.checksOutArticlesFrom(cart);
       ReceiptPrinter receiptprinter = new ReceiptPrinter();

      String line = 
      "apples                              3.00\n"
      +"  1.50 * 2.000\n"
      +"orange                              3.98\n"
      +"  1.99 * 2.000\n"
      +"2 for 1.99(orange)                 -1.99\n"
      +"\n"
      +"Total:                              4.99";

      Assertions.assertThat(line).isEqualTo(receiptprinter.printReceipt(receipt));
   }

   @Test
   public void testReceiptPrinterColumns(){
      SupermarketCatalog catalog = new FakeCatalog();

      //Produit avec Discount
      Product apples = new Product("apples", ProductUnit.Kilo);
      catalog.addProduct(apples, 1.5);

      //2 Produits
      Product orange = new Product("orange", ProductUnit.Kilo);
      catalog.addProduct(orange, 1.99);

      ShoppingCart cart = new ShoppingCart();
      cart.addItemQuantity(apples, 2);
      cart.addItemQuantity(orange, 2);

      Teller teller = new Teller(catalog);
      teller.addSpecialOffer(SpecialOfferType.TwoForAmount, orange, 1.99);

      Receipt receipt = teller.checksOutArticlesFrom(cart);
      ReceiptPrinter receiptprinter = new ReceiptPrinter();
      ReceiptPrinter receiptprintercolumns = new ReceiptPrinter(30);

      String line = 
      "apples                    3.00\n"
      +"  1.50 * 2.000\n"
      +"orange                    3.98\n"
      +"  1.99 * 2.000\n"
      +"2 for 1.99(orange)       -1.99\n"
      +"\n"
      +"Total:                    4.99";

       Assertions.assertThat(line).isEqualTo(receiptprintercolumns.printReceipt(receipt));
   }

}