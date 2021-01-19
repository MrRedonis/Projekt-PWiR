package project;

public class Ticket extends Thread{
    private int amount = 0;
    private volatile boolean cancelled = false;

    Ticket(int amount){
        this.amount = amount;
    }

    public synchronized void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
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
            try {
                Thread.sleep(1000);
                System.out.println("Ticket works!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
