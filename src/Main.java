public class Main {
    public static void main(String[] args) {
        // Menu items are declared as the abstract type MenuItem
        MenuItem pizza = new Food("Pizza", 8.50, 450, false);
        MenuItem lambKebab = new Food("Lamb Kebab", 11.00, 300, true);
        MenuItem icedTea = new Drink("Iced Tea", 3.30, 400);

        Menu menu = new Menu("Today's Menu");
        menu.addItem(pizza);
        menu.addItem(lambKebab);
        menu.addItem(icedTea);

        Restaurant restaurant = new Restaurant("Chorsu Grill House", "Chorsu Bazaar, Tashkent", menu);

        Customer customer = new Customer("Aziz Karimov", "998901234567");
        Order order = new Order(customer);
        order.addItem(new OrderItem(pizza, 1));
        order.addItem(new OrderItem(lambKebab, 2));

        OrderItem icedTeaItem = new OrderItem(icedTea, 1);
        order.addItem(icedTeaItem);
        icedTeaItem.setQuantity(2); // the customer asked for one more iced tea

        Receipt receipt = new Receipt(restaurant, order, 0.10);

        // Polymorphism: the same print() call gives different output for a menu and a receipt
        Printable[] documents = {restaurant.getMenu(), receipt};
        for (Printable document : documents) {
            document.print();
            System.out.println();
        }
    }
}
