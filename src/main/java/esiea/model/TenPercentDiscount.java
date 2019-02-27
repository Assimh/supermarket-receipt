package esiea.model;

import esiea.model.*;

import java.util.ArrayList;
import java.util.List;

public class TenPercentDiscount implements Offers
{
    private Product product;
    private double argument = 0.0;
    private final SpecialOfferType type = SpecialOfferType.TenPercentDiscount;
    private Discount discount = null;
    public TenPercentDiscount(Product product)
    {
        this.product = product;
    }

    @Override
    public ProductQuantity getProduct()
    {
        return new ProductQuantity(this.product,1.0);
    }

    @Override
    public Discount getDiscount()
    {
        return this.discount;
    }
    @Override
    public void applyDiscount(ProductQuantity productQuantity, double unitPrice)
    {
        discount = new Discount(this.product, this.argument + "% off", productQuantity.getQuantity() * unitPrice * this.argument / 100.0);
    }

}
