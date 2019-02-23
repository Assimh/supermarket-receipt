package esiea.model;

import org.junit.jupiter.api.Test;
import esiea.model.ReceiptItem;
import org.assertj.core.api.Assertions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ProductTest {

    @Test
    public void testGetName(){

        Product apples = new Product("apples", ProductUnit.Kilo);

        Assertions.assertThat(apples.getName()).isEqualTo("apples");

    }

    @Test
    public void testGetUnit(){

        Product apples = new Product("apples", ProductUnit.Kilo);

        Assertions.assertThat(apples.getUnit()).isEqualTo(ProductUnit.Kilo);
    }

     @Test
    public void testEquals () {

        Product apples = new Product("apples", ProductUnit.Kilo);

        Discount discount = new Discount(apples, "Apples Discount", 0.199);

        Product banane = new Product("banane", ProductUnit.Kilo);
        Product toothbrush = new Product("toothbrush", ProductUnit.Each);
        Product apples1 = new Product("apples", ProductUnit.Kilo);
        Product apples2 = new Product("apples", ProductUnit.Each);

        Assertions.assertThat(apples.equals(apples)).isEqualTo(true);
        Assertions.assertThat(apples.equals(null)).isEqualTo(false);

        Assertions.assertThat(apples.equals(discount)).isEqualTo(false);

        Assertions.assertThat(apples.equals(banane)).isEqualTo(false);
        Assertions.assertThat(apples.equals(toothbrush)).isEqualTo(false);
        
        Assertions.assertThat(apples.equals(apples1)).isEqualTo(true);
        Assertions.assertThat(apples.equals(apples2)).isEqualTo(false);


    }

    @Test
    public void testHashCode(){

        Product apples = new Product("apples", ProductUnit.Kilo);

        Assertions.assertThat(apples.hashCode()).isEqualTo(Objects.hash("apples", ProductUnit.Kilo));
    }

        
    @Test
    public void testgetProduct(){

        Product apples = new Product("apples", ProductUnit.Kilo);

        ProductQuantity applesQuantity = new ProductQuantity(apples, 2.5);
        
        Assertions.assertThat(applesQuantity.getProduct()).isEqualTo(apples);
    }

    @Test
    public void testgetQuantity(){

        Product apples = new Product("apples", ProductUnit.Kilo);

        ProductQuantity applesQuantity = new ProductQuantity(apples, 2.5);

        Assertions.assertThat(applesQuantity.getQuantity()).isEqualTo(2.5);
    }



}