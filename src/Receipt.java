/**
 * The printed receipt for an order: restaurant header, order lines and totals with tax.
 */
public class Receipt implements Printable {
    private final Restaurant restaurant;
    private final Order order;
    private final double taxRate;

    public Receipt(Restaurant restaurant, Order order, double taxRate) {
        this.restaurant = restaurant;
        this.order = order;
        this.taxRate = taxRate;
    }

    public double getSubtotal() {
        return order.getSubtotal();
    }

    public double getTax() {
        return getSubtotal() * taxRate;
    }

    public double getTotal() {
        return getSubtotal() + getTax();
    }

    @Override
    public void print() {
        Customer customer = order.getCustomer();

        System.out.println(centered(restaurant.getName()));
        System.out.println(centered(restaurant.getAddress()));
        System.out.println("=".repeat(LINE_WIDTH));
        System.out.println("Order No:  " + order.getOrderNumber());
        System.out.println("Customer:  " + customer.getFullName() + " (" + customer.getPhoneNumber() + ")");
        System.out.println("-".repeat(LINE_WIDTH));
        for (OrderItem item : order.getItems()) {
            System.out.printf("%-26s x%-3d%10s%n",
                    item.getMenuItem().getName(), item.getQuantity(), formatMoney(item.getLineTotal()));
        }
        System.out.println("-".repeat(LINE_WIDTH));
        printTotalLine("Subtotal:", getSubtotal());
        printTotalLine(String.format("Tax (%d%%):", Math.round(taxRate * 100)), getTax());
        printTotalLine("TOTAL:", getTotal());
    }

    private void printTotalLine(String label, double amount) {
        System.out.printf("%-30s%10s%n", label, formatMoney(amount));
    }

    private String formatMoney(double amount) {
        return String.format("$%.2f", amount);
    }

    private String centered(String text) {
        int padding = Math.max(0, (LINE_WIDTH - text.length()) / 2);
        return " ".repeat(padding) + text;
    }
}
