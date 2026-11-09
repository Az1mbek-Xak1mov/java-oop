/**
 * A dish or a drink that the restaurant sells.
 * Abstract, because every real menu item is either food or a drink.
 */
public abstract class MenuItem {
    private final String name;
    private final double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Short text shown on the menu, e.g. "Pizza (food, 450 g)".
     * Each kind of menu item describes itself differently.
     */
    public abstract String getDescription();
}
