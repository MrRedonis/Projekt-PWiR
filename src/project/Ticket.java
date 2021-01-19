package project;

public class Ticket {
    int amount = 0;
    int sold = 0;

    public synchronized void setAmount(int amount) {
        this.amount = amount;
    }

    public synchronized int getAmount() {
        return amount;
    }

    public synchronized void addAmount() {
        this.amount += 1;
    }

    public synchronized void reduceAmount() {
        this.amount -= 1;
    }

    public synchronized int getSold() {
        return sold;
    }

    public synchronized void addSoldTicket(){
        this.sold += 1;
    }
}
