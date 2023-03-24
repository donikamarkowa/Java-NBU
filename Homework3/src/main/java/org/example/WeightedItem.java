package org.example;

public class WeightedItem extends DeliverableItem{
    public Material material;
    public double weight;
    public static double pricePerKg;

    public WeightedItem(boolean toClientsAddress, Material material, double weight, double pricePerKg) {
        super(toClientsAddress);
        this.material = material;
        this.weight = weight;
        this.pricePerKg = pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        WeightedItem.pricePerKg = Math.max(pricePerKg, 2);
    }

    @Override
    public double deliveryPrice() {
        double deliveryPrice;
        if (toClientsAddress){
            deliveryPrice =  (this.weight*this.pricePerKg)+additionalPrice;
        }
        else{
            deliveryPrice = this.weight*this.pricePerKg;
        }
        if(material.isFragile){
            deliveryPrice += deliveryPrice*0.01;
        }

        return deliveryPrice;
    }
}
