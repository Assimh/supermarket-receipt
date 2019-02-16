package esiea.model;

import org.junit.jupiter.api.Test;
import esiea.ReceiptPrinter;
import org.assertj.core.api.Assertions;

public class DiscountTest {

@Test
    public void getDescriptiontest(){
        Product apples = new Product("apples", ProductUnit.Kilo);
        Discount testDiscount = new Discount(apples, "Apples Discount", 1.99);

        Assertions.assertThat(testDiscount.getDescription()).isEqualTo("Apples Discount");
    }

    @Test
    public void getDiscountAmounttest(){
        Product apples = new Product("apples",ProductUnit.Kilo);
        Discount testDiscount = new Discount(apples, "Apples Discount", 1.99);

        Assertions.assertThat(testDiscount.getDiscountAmount()).isEqualTo(1.99);
    }

    @Test
    public void getProducttest(){
        Product apples = new Product("apples",ProductUnit.Kilo);
        Discount testDiscount = new Discount(apples, "Apples Discount", 1.99);

        Assertions.assertThat(testDiscount.getProduct()).isEqualTo(apples);
    }
}