package project;

public class TicketOffice extends Thread{
    int paper = 0;
    int ink = 0;
    boolean taken;
    boolean broken;
    boolean active;
    int sold = 0;

    public void setInk(int ink) {
        this.ink = ink;
    }

    public void setPaper(int paper) {
        this.paper = paper;
    }

    public synchronized int getInk() {
        return ink;
    }

    public synchronized int getPaper() {
        return paper;
    }

    public synchronized void reduceInk(){
        this.ink -= 1;
    }

    public synchronized void reducePaper(){
        this.paper -= 1;
    }

    public synchronized void printTicket(){
        reduceInk();
        reducePaper();
        addSoldTicket();
    }

    public synchronized boolean isTaken(){
        return this.taken;
    }

    public synchronized boolean isBroken(){
        return this.broken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public synchronized int getSold() {
        return sold;
    }

    public synchronized void addSoldTicket(){
        this.sold += 1;
    }

    @Override
    public void run() {
        while (this.active){
            System.out.println("Ticket works!");
        }

    }
}
