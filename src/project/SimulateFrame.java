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

        JButton stopT5=new JButton("Stop Kasa 5");
        stopT5.addActionListener(p->simpanel.onStopT5());
        JButton startT5=new JButton("Start Kasa 5");
        startT5.addActionListener(p->simpanel.onStartT5());


        JButton stopT4=new JButton("Stop Kasa 4");
        stopT4.addActionListener(p->simpanel.onStopT4());
        JButton startT4=new JButton("Start Kasa 4");
        startT4.addActionListener(p->simpanel.onStartT4());

        JButton stopT3=new JButton("Stop Kasa 3");
        stopT3.addActionListener(p->simpanel.onStopT3());
        JButton startT3=new JButton("Start Kasa 3");
        startT3.addActionListener(p->simpanel.onStartT3());


        JButton stopT2=new JButton("Stop Kasa 2");
        stopT2.addActionListener(p->simpanel.onStopT2());
        JButton startT2=new JButton("Start Kasa 2");
        startT2.addActionListener(p->simpanel.onStartT2());


        JButton stopT1=new JButton("Stop Kasa 1");
        stopT1.addActionListener(p->simpanel.onStopT1());
        JButton startT1=new JButton("Start Kasa 1");
        startT1.addActionListener(p->simpanel.onStartT1());

      //  simpanel.run();
        start.addActionListener(p -> simpanel.onStart());


        start.addActionListener(p -> { start.setEnabled(false);stop.setEnabled(true); });
        opt.add(start);
        opt.add(stopT6);
        opt.add(startT6);

        opt.add(stopT5);
        opt.add(startT5);
        opt.add(stopT4);
        opt.add(startT4);
        opt.add(stopT3);
        opt.add(startT3);
        opt.add(stopT2);
        opt.add(startT2);
        opt.add(stopT1);
        opt.add(startT1);

        stop.addActionListener(p->simpanel.onStop());
        stop.setEnabled(false);

        stop.addActionListener(p->{stop.setEnabled(false);start.setEnabled(true);});

        opt.add(stop);

        panel.add(opt, BorderLayout.NORTH);
        panel.add(simpanel, BorderLayout.CENTER);
        setContentPane(panel);
    }


}
