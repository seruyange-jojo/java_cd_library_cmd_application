import java.util.Arrays;

public class Customer {
    private String name;
    private String[] order;
    private double orderCost;
    private String telephone;

    public Customer(String name, String[] order, double orderCost, String telephone) {
        this.name = name;
        this.order = order;
        this.orderCost = orderCost;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getOrder() {
        return order;
    }

    public void setOrder(String[] order) {
        this.order = order;
    }

    public double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(double orderCost) {
        this.orderCost = orderCost;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String toString() {
        return "Customer [name=" + name + ", order=" + Arrays.toString(order) +
               ", orderCost=" + orderCost + ", telephone=" + telephone + "]";
    }
}
