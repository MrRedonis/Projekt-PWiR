package project;


import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {

        boolean cond=false;



        public void paintComponent(Graphics g) {
            System.out.println("Repaint");
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Serif", Font.PLAIN, 24));
            g2.drawString("Kasa biletowa",100,70);
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







