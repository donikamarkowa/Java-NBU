public class ElectricDevice {
     Manufacturer manufacturer;

     int minWarranty;

    public ElectricDevice(Manufacturer manufacturer, int minWarranty) {
        this.manufacturer = manufacturer;
        this.minWarranty = Math.max(6, minWarranty);
    }

    public int warranty() {
        return manufacturer.isLongTermWarranty ? minWarranty + 12 : minWarranty;
    }
}
