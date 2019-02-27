package esiea.model;

import java.util.List;

public interface Offers
{
    ProductQuantity getProduct();
    Discount getDiscount();
    void applyDiscount(ProductQuantity productQuantity, double unitPrice);
}
