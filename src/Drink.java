public class Drink extends MenuItem {
    private final int volumeMl;

    public Drink(String name, double price, int volumeMl) {
        super(name, price);
        this.volumeMl = volumeMl;
    }

    @Override
    public String getDescription() {
        return getName() + " (drink, " + volumeMl + " ml)";
    }
}
