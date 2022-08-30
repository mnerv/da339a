package Task03.View;

import Task03.Controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class MainPanel extends JPanel {
    Controller controller;

    CenterPanel pnlCenter;
    SouthPanel pnlSouth;

    JTextArea txtAreaInfo;
    BorderLayout layout;

    public MainPanel(Controller controller) {
        this.controller = controller;
        setupPanel();
    }

    private void setupPanel() {
        layout = new BorderLayout();
        setLayout(layout);

        Border border = this.getBorder();
        Border margin = BorderFactory.createEmptyBorder(12, 12, 12, 12);
        setBorder(new CompoundBorder(border, margin));

        pnlCenter = new CenterPanel(controller); // labels and textboxes
        add(pnlCenter, layout.CENTER);

        createInfoTextAreaAtEast(); // output at right

        // Buttons at south
        pnlSouth = new SouthPanel(controller);
        add(pnlSouth, layout.SOUTH);
    }

    // This method can also make its own class
    private void createInfoTextAreaAtEast() {
        JPanel pnlProductInfo = new JPanel();
        txtAreaInfo = new JTextArea();
        txtAreaInfo.setBorder(BorderFactory.createLoweredBevelBorder());
        // txtAreaInfo.setSize(new Dimension(150,150));
        Font font = new Font("Courier New", Font.ITALIC, 12);
        txtAreaInfo.setFont(font);
        txtAreaInfo.setPreferredSize(new Dimension(200, 100));
        txtAreaInfo.setEditable(false);
        txtAreaInfo.setBackground(new Color(192, 192, 192));
        pnlProductInfo.add(txtAreaInfo);

        add(pnlProductInfo, layout.EAST);
    }

    public void setTxtAreaInfo(String text) {
        txtAreaInfo.setText(text);
    }

    public CenterPanel getPnlCenter() {
        return pnlCenter;
    }

    public SouthPanel getPnlSouth() {
        return pnlSouth;
    }

}
