import java.util.ArrayList;
import java.util.List;

public class Menu implements Printable {
    private final String title;
    private final List<MenuItem> items = new ArrayList<>();

    public Menu(String title) {
        this.title = title;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public void print() {
        System.out.println(title.toUpperCase());
        System.out.println("-".repeat(LINE_WIDTH));
        for (MenuItem item : items) {
            // Polymorphism: Food and Drink describe themselves differently
            System.out.printf("%-32s%8s%n", item.getDescription(), String.format("$%.2f", item.getPrice()));
        }
    }
}
