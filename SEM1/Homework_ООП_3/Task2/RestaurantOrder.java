package SEM1.Homework_ООП_3.Task2;

public class RestaurantOrder {
    private String orderId;
    private int tableNumber;
    private MenuItem[] orderItems;
    private String orderStatus;

    private int totalOrders = 0;
    private final int MAX_TABLE_NUMBER = 50;

    public RestaurantOrder(String orderId, int tableNumber, MenuItem[] orderItems, String orderStatus) {
        setOrderId(orderId);
        setTableNumber(tableNumber);
        setOrderItems(orderItems);
        setOrderStatus(orderStatus);
    }

    public void addItem(MenuItem item) {
        MenuItem[] oi2 = new MenuItem[orderItems.length + 1];
        for (int i = 0; i < orderItems.length; i++) {
            oi2[i] = orderItems[i];
        }
        oi2[orderItems.length + 1] = item;
        orderItems = oi2;
    }

    public void removeItem(String itemId) {
        MenuItem[] oi2 = new MenuItem[orderItems.length - 1];
        boolean flag = false;
        for (int i = 0; i < orderItems.length; i++) {
            if (oi2[i].getItemId().equals(itemId)) {flag = true;}
            else {oi2[flag ? i - 1: i] = orderItems[i];}
        }
        assert flag;
        orderItems = oi2;
    }

    public double calculateTotal() {
        double ret = 0;
        for (MenuItem i: orderItems) {
            ret += i.getPrice();
        }
        return ret;
    }

    public void getOrderDetails() {
        for (MenuItem i: orderItems) {
            System.out.println(i.displayInfo());
        }
    }

    public void updateStatus(String newStatus) {
        setOrderStatus(newStatus);
    }

    public MenuItem[] getItemsByType(String type) {
        int d = 0;
        for (MenuItem i: orderItems) {
            if (i.getItemType().equals(type)) {d++;}
        }
        MenuItem[] ret = new MenuItem[d];
        int n = 0;
        for (MenuItem i: orderItems) {
            if (i.getItemType().equals(type)) {ret[n]=i; n++;}
        }
        return ret;
    }

    public int estimatePreparationTime() {
        int ret = 0;
        for (MenuItem i: orderItems) {
            if (i.getPrice() > ret) {ret = i.getCookingTime();}
        }
        return ret;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        assert tableNumber <= MAX_TABLE_NUMBER;
        this.tableNumber = tableNumber;
    }

    public MenuItem[] getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(MenuItem[] orderItems) {
        this.orderItems = orderItems;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getTotalOrders() {
        return totalOrders;
    }
}
