import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A customer's order. It is made up of order items (aggregation)
 * and belongs to a customer.
 */
public class Order {
    private static int nextOrderNumber = 1;

    private final String orderNumber;
    private final Customer customer;
    private final List<OrderItem> items = new ArrayList<>();

    public Order(Customer customer) {
        this.orderNumber = String.format("ORD-%04d", nextOrderNumber++);
        this.customer = customer;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (OrderItem item : items) {
            subtotal += item.getLineTotal();
        }
        return subtotal;
    }
}
