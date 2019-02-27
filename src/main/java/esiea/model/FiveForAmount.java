package esiea.model;
import esiea.model.*;

import java.util.ArrayList;
import java.util.List;

public class FiveForAmount implements Offers
{
    private Product product;
    private double argument;
    private final SpecialOfferType type = SpecialOfferType.TenPercentDiscount;
    private Discount discount = null;
    public FiveForAmount(Product product, double argument)
    {
        this.product = product;
        this.argument = argument;
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
        int x = 3;
        int quantityAsInt = (int) productQuantity.getQuantity();
        int numberOfXs = quantityAsInt / x;
        if(quantityAsInt > 2)
        {
            double discountAmount = productQuantity.getQuantity() * unitPrice - ((numberOfXs * 2 * unitPrice) + quantityAsInt % 3 * unitPrice);
            discount = new Discount(this.product, "3 for 2", discountAmount);
        }
    }
}

