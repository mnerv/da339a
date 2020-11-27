package Task03.View;

import javax.swing.*;

import Task03.Model.ProductType;
import Task03.Controller.Controller;

public class MainFrame extends JFrame {
    private int width = 500;
    private int height = 400;

    Controller controller;
    MainPanel panel;

    public MainFrame(Controller controller) {
        this.controller = controller;
        setupFrame();

    }

    // standard settings
    public void setupFrame() {
        final int offsetX = width / 5;
        final int offsetY = height / 5;

        setSize(width, height);
        setTitle("Product Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(offsetX, offsetY);

        panel = new MainPanel(controller);
        setContentPane(panel);
        pack();

        setVisible(true);
    }

    public String getNameText() {
        return panel.getPnlCenter().getNameText();
    }

    public void setNameText(String str) {
        panel.getPnlCenter().setNameText(str);
    }

    public String getPriceText() {
        return panel.getPnlCenter().getPriceText();
    }

    public String getCount() {
        return panel.getPnlCenter().getCount();
    }

    public void showProductInfo(String str) {
        panel.setTxtAreaInfo(str);
    }

    public void errMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
