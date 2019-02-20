package esiea.model;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
public class ReceiptTest
{
        @Test
        public void getTotalPriceTest()
        {
                Receipt receipt = new Receipt();
                //ReceiptItem receiptItem = new ReceiptItem(new Product("apples", ProductUnit.Kilo), 2.0, 3.0, 6.0);
                //Discount discount = new Discount(product, description, discountAmount)
                receipt.addProduct(new Product("apples", ProductUnit.Kilo), 2.0, 3.0, 6.0);
                Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(6.0);
        }
        @Test
        public void addProductTest()
        {
                Receipt receipt = new Receipt();
                ReceiptItem receiptItem = new ReceiptItem(new Product("apples", ProductUnit.Kilo), 2.0, 3.0, 6.0);
                receipt.addProduct(new Product("apples", ProductUnit.Kilo), 2.0, 3.0, 6.0);
                for(ReceiptItem x : receipt.getItems())
                {
                        Assertions.assertThat(x).isEqualTo(receiptItem);
                }
        }
        @Test
        public void addDiscountTest()
        {
                Receipt receipt = new Receipt();
                Product product = new Product("apples", ProductUnit.Kilo);
                receipt.addProduct(product, 2.0, 3.0, 6.0);
                receipt.addDiscount(new Discount(product, "pomme", 2.0));
                Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(4.0);
        }
        @Test
        public void getDiscountTest()
        {
                Receipt receipt = new Receipt();
                ReceiptItem receiptItem = new ReceiptItem(new Product("apples", ProductUnit.Kilo), 2.0, 3.0, 6.0);
                Product product = new Product("apples", ProductUnit.Kilo);
                Discount discount = new Discount(product, "pomme", 2.0);
                receipt.addDiscount(discount);
                for(Discount x : receipt.getDiscounts())
                {
                        Assertions.assertThat(x).isEqualTo(discount);
                }
        }
}