package PostOffice.View;

import PostOffice.Controller.PostalController;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class MainPanel extends JPanel {
    private PostalController controller;
    private int width;
    private int height;

    private InfoPanel senderPanel;
    private InfoPanel receivePanel;
    private SouthPanelButtons pnlSouth;

    // JTextArea txtAreaInfo;
    BorderLayout layout;
    EastPanelGuestList pnlEast;

    public MainPanel(PostalController controller, int width, int height) {
        this.controller = controller;
        this.width = width;
        this.height = height;
        setupPanel();
    }

    public InfoPanel getPnlCenter() {
        return senderPanel;
    }

    public InfoPanel getReceivePanel() {
        return receivePanel;
    }

    public SouthPanelButtons getPnlSouth() {
        return pnlSouth;
    }

    public EastPanelGuestList getPnlEast() {
        return pnlEast;
    }

    private void setupPanel() {
        layout = new BorderLayout();
        setLayout(layout);

        Border border = this.getBorder();
        Border margin = BorderFactory.createEmptyBorder(6, 6, 6, 6);
        setBorder(new CompoundBorder(border, margin));

        senderPanel = new InfoPanel(controller, "Sender", 4 * width / 10, 8 * height / 10, 6);
        add(senderPanel, layout.WEST);

        receivePanel = new InfoPanel(controller, "Receiver", 4 * width / 10, 8 * height / 10, 6);
        add(receivePanel, layout.CENTER);

        // Buttons at south
        pnlSouth = new SouthPanelButtons(controller, width, 2 * height / 10);
        add(pnlSouth, layout.SOUTH);

        pnlEast = new EastPanelGuestList(controller, 6 * width / 10, 8 * height / 10, 6);
        add(pnlEast, BorderLayout.EAST);
    }

}
