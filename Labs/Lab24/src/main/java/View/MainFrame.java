package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JFrame frame;
    private MainPanel panel;

    private int width = 600;
    private int height = 600;
    private Controller controller;

    // default konstruktor
    public MainFrame(Controller controller) {
        this.controller = controller;

        frame = new JFrame("Time Tracker");
        frame.setSize(width, height);
        frame.setBounds(10, 10, width, height);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(150, 150);

        // skapa ett objekt av panelen
        panel = new MainPanel(controller, width, height);
        // lägg till panelen på mainFrame
        frame.setContentPane(panel);

        frame.getContentPane().setPreferredSize(new Dimension(width, height));
        frame.pack();
        frame.setResizable(false);

        frame.pack();
        // frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void updateTableData(String[][] tableData) {
        panel.setTableData(tableData);
    }
}
