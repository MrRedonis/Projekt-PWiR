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

        super("Simulate");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel opt = new JPanel();

        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
      //  simpanel.run();
        start.addActionListener(p -> simpanel.onStart());


        start.addActionListener(p -> { start.setEnabled(false);stop.setEnabled(true); });
        opt.add(start);

        stop.addActionListener(p->simpanel.onStop());
        stop.setEnabled(false);

        stop.addActionListener(p->{stop.setEnabled(false);start.setEnabled(true);});

        opt.add(stop);

        panel.add(opt, BorderLayout.NORTH);
        panel.add(simpanel, BorderLayout.CENTER);
        setContentPane(panel);
    }


}
