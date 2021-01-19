package project;


import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {


    Ticket ticket1=new Ticket(15);
    TicketOffice T1=new TicketOffice(ticket1,10,10);
    TicketOffice T2=new TicketOffice(ticket1,10,10);
    TicketOffice T3=new TicketOffice(ticket1,10,10);
    TicketOffice T4=new TicketOffice(ticket1,10,10);
    TicketOffice T5=new TicketOffice(ticket1,10,10);
    TicketOffice T6=new TicketOffice(ticket1,10,10);

        boolean cond=false;

        int x=1;

        public void paintComponent(Graphics g) {
            System.out.println("Repaint");
            super.paintComponent(g);
            Graphics2D g1 = (Graphics2D) g;
            Graphics2D g2 = (Graphics2D) g;
            Graphics2D g3 = (Graphics2D) g;
            Graphics2D g4 = (Graphics2D) g;
            Graphics2D g5 = (Graphics2D) g;
            Graphics2D g6 = (Graphics2D) g;

            g1.setColor(Color.BLACK);
            g1.setFont(new Font("Serif", Font.PLAIN, 24));
            g1.drawString("Kasa biletowa",100,70);
            if(T1.taken) g1.setColor(Color.RED);
            else g1.setColor(Color.BLACK);
            g1.fillRect(50,150,50,50);

            for(int i=0;i<T1.sold;i++)
            {
                g1.setColor(Color.GRAY);
                g1.fillRect(50,(250+i*45),50,25);
            }

            if(T2.taken) g2.setColor(Color.RED);
            else g2.setColor(Color.BLACK);
            g2.fillRect(150,150,50,50);

            for(int i=0;i<T2.sold;i++)
            {
                g2.setColor(Color.GRAY);
                g2.fillRect(150,(250+i*45),50,25);
            }

            if(T3.taken) g3.setColor(Color.RED);
            else g3.setColor(Color.BLACK);
            g3.fillRect(250,150,50,50);

            for(int i=0;i<T3.sold;i++)
            {
                g3.setColor(Color.GRAY);
                g3.fillRect(250,(250+i*45),50,25);
            }

            if(T4.taken) g4.setColor(Color.RED);
            else g4.setColor(Color.BLACK);
            g4.fillRect(350,150,50,50);

            for(int i=0;i<T4.sold;i++)
            {
                g4.setColor(Color.GRAY);
                g4.fillRect(350,(250+i*45),50,25);
            }

            if(T5.taken) g5.setColor(Color.RED);
            else g5.setColor(Color.BLACK);
            g5.fillRect(450,150,50,50);

            for(int i=0;i<T5.sold;i++)
            {
                g5.setColor(Color.GRAY);
                g5.fillRect(450,(250+i*45),50,25);
            }

            if(T6.taken) g6.setColor(Color.RED);
            else g6.setColor(Color.BLACK);
            g6.fillRect(550,150,50,50);

            for(int i=0;i<T6.sold;i++)
            {
                g6.setColor(Color.GRAY);
                g6.fillRect(550,(250+i*45),50,25);
            }
            x+=20;
        }

        class AnimationThread extends Thread {

            boolean sus = true;

            public void pause() {
                sus = true;
            }

            public synchronized void stoppasue() {
                sus = false;
                notify();
            }

            public void run() {
                T1.start();
                T2.start();
                T3.start();
                T4.start();
                T5.start();
                T6.start();
                while (true) {
                    try {
                       System.out.println("blabla");
                    } catch (Exception e) {
                        System.out.println("Błąd w symulacji");
                        e.printStackTrace();
                    }

                    repaint();
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
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        void onStart() {
            System.out.println("Start or resume animation thread");
            // anim.start();
            anim.stoppasue();
        }

        void onStop() {
            System.out.println("Suspend animation thread");
            anim.pause();
        }

        private AnimationThread anim = new AnimationThread();
        int height, width;

        UserPanel(int height, int width) throws Exception {
            this.height = height;
            this.width = width;
            anim.start();
            setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.0f)));
        }
    }







