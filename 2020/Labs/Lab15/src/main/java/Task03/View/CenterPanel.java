package Task03.View;

import Task03.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CenterPanel extends JPanel {
    private int width = 200;
    private int height = 200;

    private JTextField txtName;
    private JTextField txtPrice;
    private JTextField txtCount;
    private JComboBox cmbUnits;

    private JPanel pnlLeft; // for labels at left
    private JPanel pnlRight; // for textboxes at right

    private Controller controller;

    public CenterPanel(Controller controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(width, height));
        CreateComponents();
    }

    private void CreateComponents() {
        createComponentsOnLeftPanel();
        createComponentsOnRightPanel();
        createAndInitiateCombox();
    }

    private void createComponentsOnLeftPanel() {
        JLabel lblName = new JLabel("Product name");
        JLabel lblPrice = new JLabel("Price");
        JLabel lblCount = new JLabel("Quantity");
        JLabel lblUnit = new JLabel("Unit");

        GridLayout layoutLeft = new GridLayout(8, 1, 2, 2);

        pnlLeft = new JPanel(layoutLeft);
        pnlLeft.setPreferredSize(new Dimension(width / 2, height));
        pnlLeft.add(lblName);

        pnlLeft.add(lblPrice);
        pnlLeft.add(lblCount);
        pnlLeft.add(lblUnit);

        add(pnlLeft, BorderLayout.WEST);
    }

    private void createComponentsOnRightPanel() {
        GridLayout layoutRight = new GridLayout(8, 1, 2, 2);
        pnlRight = new JPanel(layoutRight);
        pnlRight.setPreferredSize(new Dimension(width / 2, height));

        Dimension dim = new Dimension(50, 50);
        txtName = new JTextField("Egg");
        txtName.setPreferredSize(dim);

        txtPrice = new JTextField("19.90");
        txtPrice.setPreferredSize(dim);

        txtCount = new JTextField("24");
        txtCount.setPreferredSize(dim);

        pnlRight.add(txtName);
        pnlRight.add(txtPrice);
        pnlRight.add(txtCount);

        add(pnlRight, BorderLayout.CENTER);
    }

    private void createAndInitiateCombox() {
        cmbUnits = new JComboBox(controller.getUnitItems());
        cmbUnits.setSelectedIndex(0);
        pnlRight.add(cmbUnits);
        cmbUnits.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object obj = cmbUnits.getSelectedItem();
                controller.setUnitItem(obj);
            }
        });
    }

    public String getNameText() {
        return txtName.getText();
    }

    public void setNameText(String text) {
        txtName.setText(text);
    }

    public String getPriceText() {
        return txtPrice.getText();
    }

    public void setPriceText(String text) {
        txtPrice.setText(text);
    }

    public String getCount() {
        return txtCount.getText();
    }

}
