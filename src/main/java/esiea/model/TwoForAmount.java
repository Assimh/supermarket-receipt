package esiea.model;
import esiea.model.*;

import java.util.ArrayList;
import java.util.List;

public class TwoForAmount implements Offers
{
    private Product product;
    private double quantity;
    private double argument;
    private final SpecialOfferType type = SpecialOfferType.TenPercentDiscount;
    private Discount discount;// = new Discount(this.product, "2 for " + this.argument, 5.0);
    public TwoForAmount(Product product, double argument)
    {
        this.product = product;
        this.argument = argument;
        discount = new Discount(this.product, "2 for " + this.argument, 5.0);
    }

    @Override
    public ProductQuantity getProduct()
    {
        return new ProductQuantity(this.product,4.0);
    }

    @Override
    public Discount getDiscount()
    {
        return this.discount;
    }
    @Override
    public void applyDiscount(ProductQuantity productQuantity, double unitPrice)
    {
        int x = 2;
        int quantityAsInt = (int) productQuantity.getQuantity();
        if (quantityAsInt >= 2)
        {
            double total = this.argument * quantityAsInt / x + quantityAsInt % 2 * unitPrice;
            double discountN = unitPrice * productQuantity.getQuantity() - total;
            discount = new Discount(this.product, "2 for " + this.argument, discountN);
        }
    }
}
