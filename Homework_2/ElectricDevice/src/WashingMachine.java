public class WashingMachine extends ElectricDevice {
    private boolean isDryer;


    public WashingMachine(Manufacturer manufacturer, int minWarranty, boolean isDryer) {
        super(manufacturer, minWarranty);
        this.isDryer = isDryer;
    }

    @Override
    public int warranty() {
        final int basicGuarantee = super.warranty();
        final int extraGuarantee = isDryer ? this.minWarranty / 2 : 0;
        return basicGuarantee + extraGuarantee;
    }
}

