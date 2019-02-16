package esiea.model;

import org.junit.jupiter.api.Test;
import esiea.ReceiptPrinter;
import org.assertj.core.api.Assertions;

public class DiscountTest {

@Test
    public void testDiscount(){
        Product apples = new Product("apples",ProductUnit.Kilo);
        Discount testDiscount = new Discount(apples, "Product apples", 1.99);
        Assertions.assertThat(testDiscount.getDescription()).isEqualTo("Product apples");
        Assertions.assertThat(testDiscount.getDiscountAmount()).isEqualTo(1.99);
        Assertions.assertThat(testDiscount.getProduct()).isEqualTo(apples);
    }
 
}