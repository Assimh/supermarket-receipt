package esiea.model;

import org.junit.jupiter.api.Test;
import esiea.model.ReceiptItem;
import org.assertj.core.api.Assertions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
	public void EqualsReceiptTest() {
		Product apples = new Product("apples", ProductUnit.Kilo);
		Product toothbrush = new Product("toothbrush", ProductUnit.Kilo);

		ReceiptItem receiptItem = new ReceiptItem(apples, 2.0, 1.99, 3.98);
        ReceiptItem receiptItem1 = new ReceiptItem(toothbrush, 3.0, 0.99, 0.97);
        ReceiptItem receiptItem2 = new ReceiptItem(apples, 1.0, 1.99, 3.98);
        ReceiptItem receiptItem3 = new ReceiptItem(apples, 2.0, 2.99, 3.98);
        ReceiptItem receiptItem4 = new ReceiptItem(apples, 2.0, 1.99, 4.98);
        ReceiptItem receiptItem5 = new ReceiptItem(apples, 2.0, 1.99, 3.98);

        Assertions.assertThat(receiptItem.equals(receiptItem)).isEqualTo(true);
        Assertions.assertThat(receiptItem).isNotEqualTo(null);
        Assertions.assertThat(receiptItem.equals(receiptItem1)).isEqualTo(false);
        Assertions.assertThat(receiptItem.equals(receiptItem2)).isEqualTo(false);
        Assertions.assertThat(receiptItem.equals(receiptItem3)).isEqualTo(false);
        Assertions.assertThat(receiptItem.equals(receiptItem4)).isEqualTo(false);
        Assertions.assertThat(receiptItem.equals(receiptItem5)).isEqualTo(true);

    }

    @Test
    public void hashCodeTest(){
        Product apples = new Product("apples",ProductUnit.Kilo);

        ReceiptItem receiptItem = new ReceiptItem(apples, 2.0, 1.99, 3.98);

        Assertions.assertThat(receiptItem.hashCode()).isEqualTo(Objects.hash(apples, 1.99, 3.98, 2.0));
    }
}
