package Homework_Podgotovka_CW_1.Task5;

import java.util.Objects;

public class Subscription {
    private int id;
    private String serviceName;
    private double monthlyCost;
    private boolean isPremium;

    public Subscription(int id, String serviceName, double monthlyCost, boolean isPremium) {
        this.id = id;
        this.serviceName = serviceName;
        this.monthlyCost = monthlyCost;
        this.isPremium = isPremium;
    }

    public int getId() { return id; }
    public String getServiceName() { return serviceName; }
    public double getMonthlyCost() { return monthlyCost; }
    public boolean isPremium() { return isPremium; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return id == that.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Subscription{id=" + id + ", serviceName='" + serviceName + "', isPremium=" + isPremium + "}";
    }
}