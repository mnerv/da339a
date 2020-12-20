package PostOffice.View;

import javax.swing.*;

import PostOffice.Controller.PostalController;

public class MainFrame extends JFrame {
    private int width = 800;
    private int height = 400;

    PostalController controller;
    MainPanel panel;

    public MainFrame(PostalController controller) {
        this.controller = controller;
        setupFrame();
    }

    public void setupFrame() {
        final int offsetX = width / 5;
        final int offsetY = height / 5;

        setSize(width, height);
        setTitle("Post Office");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(offsetX, offsetY);

        panel = new MainPanel(controller, width, height);
        setContentPane(panel);
        setResizable(false);
        pack();

        setVisible(true);
    }

    public String getFirstNameText() {
        return panel.getPnlCenter().getFirstNameText();
    }

    public void setFirstNameText(String str) {
        panel.getPnlCenter().setFirstNameText(str);
    }

    public String getLastNameText() {
        return panel.getPnlCenter().getLastNameText();
    }

    public void setLastNameText(String str) {
        panel.getPnlCenter().setLastNameText(str);
    }

    public String getStreetText() {
        return panel.getPnlCenter().getStreetText();
    }

    public void setStreetText(String str) {
        panel.getPnlCenter().setStreetText(str);
    }

    public String getCityText() {
        return panel.getPnlCenter().getCityText();
    }

    public void setCityText(String str) {
        panel.getPnlCenter().setCityText(str);
    }

    public String getZipCodeText() {
        return panel.getPnlCenter().getZipCodeText();
    }
}
