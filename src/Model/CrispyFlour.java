package Model;

import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount {
    int quantity;

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour() {

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity * cost;
    }

    @Override
    public LocalDate getExpiryDate() {
        return manufacturingDate.plusMonths(12);
    }

    @Override
    public double getRealMoney() {
        LocalDate today = LocalDate.now();
        if (today.isBefore(getExpiryDate().minusMonths(2))) {
            return getAmount() * 0.8;
        }else if(today.isBefore(getExpiryDate().minusMonths(4))){
            return getAmount() * 0.6;
        }else  {
            return getAmount() * 0.95;
        }
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +

                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", cost=" + cost +
                "quantity=" + quantity +
                '}';
    }
}
