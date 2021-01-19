package project;

import javax.swing.*;
import java.awt.*;

public class SimulateFrame extends JFrame {

    private UserPanel simpanel = new UserPanel(700, 630);
 /*   void run(){
        simpanel.run();
    }


  */

    public SimulateFrame() throws Exception {

        super("Kasy biletowe");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel opt = new JPanel();

        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JButton stopT6=new JButton("Stop Kasa 6");
        stopT6.addActionListener(p->simpanel.onStopT6());

        JButton startT6=new JButton("Start Kasa 6");
        startT6.addActionListener(p->simpanel.onStartT6());
      //  simpanel.run();
        start.addActionListener(p -> simpanel.onStart());


        start.addActionListener(p -> { start.setEnabled(false);stop.setEnabled(true); });
        opt.add(start);
        opt.add(stopT6);
        opt.add(startT6);
        stop.addActionListener(p->simpanel.onStop());
        stop.setEnabled(false);

        stop.addActionListener(p->{stop.setEnabled(false);start.setEnabled(true);});

        opt.add(stop);

        panel.add(opt, BorderLayout.NORTH);
        panel.add(simpanel, BorderLayout.CENTER);
        setContentPane(panel);
    }


}
