public class Food extends MenuItem {
    private final int weightGrams;
    private final boolean spicy;

    public Food(String name, double price, int weightGrams, boolean spicy) {
        super(name, price);
        this.weightGrams = weightGrams;
        this.spicy = spicy;
    }

    @Override
    public String getDescription() {
        String description = getName() + " (food, " + weightGrams + " g";
        if (spicy) {
            description += ", spicy";
        }
        return description + ")";
    }
}
