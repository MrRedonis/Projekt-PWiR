public class TicketOffice {
    int paper = 0;
    int ink = 0;

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
    }
}
