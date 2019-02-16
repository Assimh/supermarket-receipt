package esiea.model;

import org.junit.jupiter.api.Test;
import esiea.ReceiptPrinter;
import org.assertj.core.api.Assertions;

public class OfferTest {

 
 @Test
	public void TestMethodGetProduct() {
		Product apples = new Product("apples", ProductUnit.Kilo);
		Offer Myoffer = new Offer(SpecialOfferType.TenPercentDiscount, apples, 1.99);
        
		Assertions.assertThat(Myoffer.getProduct().getName()).isEqualTo("apples");

		Assertions.assertThat(Myoffer.getProduct().getName()).isNotEmpty();

		Assertions.assertThat(Myoffer.getProduct().getName()).isNotEqualTo("toothbrush");

	}
}