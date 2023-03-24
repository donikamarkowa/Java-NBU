package org.example;

public class Material extends DeliverableItem  {
    public String materialName;
    public boolean isFragile;

    public Material(String materialName, boolean isFragile) {
        super();
        this.materialName = materialName;
        this.isFragile = isFragile;
    }

    public boolean isFragile() {
        return isFragile;
    }
}
