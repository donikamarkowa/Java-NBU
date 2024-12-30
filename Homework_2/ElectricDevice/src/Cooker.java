public class Cooker extends ElectricDevice{
    private boolean isGas;

    public Cooker(Manufacturer manufacturer, int minWarranty, boolean isGas) {
        super(manufacturer, minWarranty);
        this.isGas = isGas;
    }

    @Override
    public int warranty(){
        int basicGuarantee = super.warranty();
        int extraGuarantee = isGas ? 12 : 0;
        return basicGuarantee + extraGuarantee;
    }

}
