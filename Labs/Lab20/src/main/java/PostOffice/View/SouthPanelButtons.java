package PostOffice.View;

import PostOffice.Controller.PostalController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanelButtons extends JPanel {
    private PostalController controller;
    private int width;
    private int height;

    JButton btnOK, btnChange, btnDelete;

    public SouthPanelButtons(PostalController controller, int width, int height) {
        this.controller = controller;
        this.width = width;
        this.height = height;

        int buttonHeight = height - 4; // 4 = margin
        int buttonWidth = width / 6;

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        JPanel pnlButtons = new JPanel();

        btnOK = new JButton("Add");
        Dimension dim = new Dimension(buttonWidth, buttonHeight);
        btnOK.setSize(dim);

        btnChange = new JButton("Change");
        btnChange.setSize(dim);

        btnDelete = new JButton("Delete");
        btnChange.setSize(dim);

        pnlButtons.add(btnOK);
        pnlButtons.add(btnChange);
        pnlButtons.add(btnDelete);

        add(pnlButtons);

        // addListeners();

    }

    /*
     * private void addListeners() { ActionListener listener = new
     * ButtonActionListeners();
     * 
     * rbtnBooks.addActionListener(listener); rbtnFood.addActionListener(listener);
     * rbtnOther.addActionListener(listener);
     * 
     * btnOK.addActionListener(listener); btnChange.addActionListener(listener);
     * btnDelete.addActionListener(listener); }
     * 
     * class ButtonActionListeners implements ActionListener { public void
     * actionPerformed(ActionEvent e) { if (e.getSource() == rbtnBooks) {
     * controller.productTypeChanged(ButtonType.rbtnBook); } else if (e.getSource()
     * == rbtnFood) { controller.productTypeChanged(ButtonType.rbtnFood); } else if
     * (e.getSource() == rbtnOther) {
     * controller.productTypeChanged(ButtonType.rbtnOther); }
     * 
     * if (e.getSource() == btnOK) { controller.buttonPressed(ButtonType.Add); }
     * else if (e.getSource() == btnChange) {
     * controller.buttonPressed(ButtonType.Change); } else if (e.getSource() ==
     * btnDelete) { controller.buttonPressed(ButtonType.Delete); } } }
     */
}
