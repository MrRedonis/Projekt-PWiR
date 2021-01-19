package project;


import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {

    TicketOffice T1 =new TicketOffice();
    TicketOffice T2 =new TicketOffice();
    TicketOffice T3 =new TicketOffice();
    TicketOffice T4 =new TicketOffice();
    TicketOffice T5 =new TicketOffice();
    TicketOffice T6 =new TicketOffice();

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
            g1.fillRect(50,150,50,50);
            g2.setColor(Color.BLACK);
            g2.fillRect(150,150,50,50);
            g3.setColor(Color.BLACK);
            g3.fillRect(250,150,50,50);
            g4.setColor(Color.BLACK);
            g4.fillRect(350,150,50,50);
            g5.setColor(Color.BLACK);
            g5.fillRect(450,150,50,50);
            g6.setColor(Color.BLACK);
            g6.fillRect(550,150,50,50);

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







