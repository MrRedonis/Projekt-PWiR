package project;

public class Ticket extends Thread{
    int amount = 0;
    private volatile boolean cancelled = false;

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

    public void cancell(){
        this.cancelled = true;
    }

    @Override
    public void run() {
        while (!cancelled){
            System.out.println("Ticket works!");
        }
    }
}
