package org.example;


public class Document extends DeliverableItem  {
    public static double minPrice;

    public Document(boolean toClientsAddress, double minPrice) {
        super(toClientsAddress);
        this.minPrice = minPrice;
    }

    public void setMinPrice(double minPrice) {
        Document.minPrice = Math.max(minPrice, 2);
    }

    @Override
    public double deliveryPrice() {
        if(toClientsAddress){
            return this.minPrice+=additionalPrice;
        }
        else{
            return this.minPrice;
        }
    }
}
