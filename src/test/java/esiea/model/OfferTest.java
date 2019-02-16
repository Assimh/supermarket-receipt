package esiea.model;

import org.junit.jupiter.api.Test;
import esiea.ReceiptPrinter;
import org.assertj.core.api.Assertions;

public class OfferTest {

 
 @Test
    public void offertest(){
        Product apples = new Product("apples", ProductUnit.Each);
        Offer My_offer = new Offer(SpecialOfferType.TenPercentDiscount, apples, 1.99);

        Assertions.assertThat(My_offer.getProduct()).isEqualTo(apples);
    }
}