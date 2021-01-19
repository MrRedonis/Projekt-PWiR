package project;

import java.time.Duration;
import java.util.Random;

public class TicketOffice extends Thread {
    int paper = 0;
    int ink = 0;
    boolean taken;
    boolean broken;
    boolean active;
    int sold = 0;
    Ticket ticket;
    private static final Random generator = new Random();

    TicketOffice(Ticket ticket, int paper, int ink){
        this.ticket = ticket;
        this.paper = paper;
        this.ink = ink;
    }

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

    public synchronized void reduceInk() {
        this.ink -= 1;
    }

    public synchronized void reducePaper() {
        this.paper -= 1;
    }

    public synchronized void sellTicket() throws InterruptedException {
        this.taken = true;
        if(getInk()>0 && getPaper()>0 && ticket.getAmount()>0){
            ticket.reduceAmount();
            reduceInk();
            reducePaper();
            addSoldTicket();
            Thread.sleep(Duration.ofSeconds(generator.nextInt(10)+5).toMillis());
        }
        this.taken = false;
        Thread.sleep(Duration.ofSeconds(generator.nextInt(3)+2).toMillis());
    }

    public synchronized boolean isTaken() {
        return this.taken;
    }

    public synchronized boolean isBroken() {
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

    public synchronized void addSoldTicket() {
        this.sold += 1;
    }

    boolean sus = false;

    public void pause() {
        sus = true;
    }


    public synchronized void stoppasue() {
        sus = false;
        notify();
    }

    @Override
    public void run() {

        while (true) {
            try {
                System.out.println("Ticket office works!");
                this.sellTicket();
            } catch (Exception e) {
                System.out.println("Błąd");
                e.printStackTrace();
            }
            synchronized (this) {
                try {
                    if (sus) {
                        System.out.println("Suspending");
                        wait();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            System.out.println("Działa");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

