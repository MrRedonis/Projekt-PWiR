package project;


import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

        SimulateFrame frame=new SimulateFrame();
        //frame.run();
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
