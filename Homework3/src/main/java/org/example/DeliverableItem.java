package org.example;

public abstract class DeliverableItem implements Deliverable {
    public boolean toClientsAddress;
    public static double additionalPrice;

    public DeliverableItem(boolean toClientsAddress) {
        this.toClientsAddress = toClientsAddress;
    }
    public DeliverableItem(){

    }
    public static void setAdditionalPrice(double additionalPrice) {
        DeliverableItem.additionalPrice = Math.max(additionalPrice, 2);
    }

    @Override
    public double deliveryPrice() {
        return deliveryPrice();
    }
}
