package View;

import Controller.Controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.*;

public class MainPanel extends JPanel implements ActionListener {
    private int width;
    private int height;
    private Controller controller;
    private JButton btnOK;
    private JTextField txtHours;
    private JComboBox cmbMonths;
    private JComboBox cmbDays;

    DataTableModel tableModel;
    private JTable table;

    public MainPanel(Controller controller, int width, int height) {
        this.controller = controller;
        this.width = width;
        this.height = height;

        setPreferredSize(new Dimension(width, height));
        setUpPanel();
    }

    public void setUpPanel() {
        // Create a JTable and tell it to display our model
        int rows = controller.getNumOfTableRows();

        String[] colTitles = controller.getColTitles();
        int columns = colTitles.length; // .getNumOfTableColumns();

        String[][] initialData = controller.getTableData();

        tableModel = new DataTableModel(rows, colTitles, initialData);

        table = new JTable(tableModel);

        // Put the JTable in a JScrollPane to handle scrolling
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(width - 50, height - 80));

        // Create an action listener to display the given directory
        btnOK = new JButton("OK");
        cmbMonths = new JComboBox(controller.getMonthStrings());
        cmbDays = new JComboBox(controller.getDayStrings());

        cmbMonths.setSelectedIndex(LocalDate.now().getMonthValue() - 1);
        cmbDays.setSelectedIndex(LocalDate.now().getDayOfMonth() - 1);
        txtHours = new JTextField(4);
        txtHours.setHorizontalAlignment(JTextField.RIGHT);
        JLabel lblHours = new JLabel("Number of hours worked");
        lblHours.setPreferredSize(new Dimension(180, 20));

        JPanel ctrlPane = new JPanel();
        ctrlPane.add(cmbMonths);
        ctrlPane.add(cmbDays);
        ctrlPane.add(btnOK);
        ctrlPane.add(lblHours);
        ctrlPane.add(txtHours);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
        splitPane.setDividerLocation(50);
        splitPane.setEnabled(true);
        // frame.add(splitPane);
        add(splitPane);

        btnOK.addActionListener(this);
    }

    private String[][] setTestValues(int rows, int columns) {
        String[][] emptyData = new String[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) emptyData[row][col] = "";
        }
        return emptyData;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOK) {
            if (checkHours()) {
                int day = cmbDays.getSelectedIndex();
                int month = cmbMonths.getSelectedIndex();
                double hours = Double.parseDouble(txtHours.getText());
                controller.setHours(day, month, hours);
            } else {
                JOptionPane.showMessageDialog(
                    null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean checkHours() {
        boolean ok = true;

        String strHours = txtHours.getText();
        try {
            if ((strHours == null) || (strHours.isEmpty()))
                ok = false;
            else {
                double hours = Double.parseDouble(strHours);
            }
        } catch (Exception ex) {
            ok = false;
        }
        return ok;
    }

    public void setTableData(String[][] tableData) {
        tableModel.setTableValues(tableData);
        table.setModel(tableModel);
        table.repaint();
    }
}
