package View;

import javax.swing.table.AbstractTableModel;

public class DataTableModel extends AbstractTableModel {
    private int columns = 12;
    private int rows = 31;
    private String[] columnNames;// = {"col 1","col 2","col 3","col 4"};
    private String[][] dataStrings;// = { {"00", "01", "02", "03"}, {"10", "11", "12", "13"}};

    public DataTableModel(int rows, String[] colTitles, String[][] dataStrings) {
        this.columns = colTitles.length;
        this.rows = rows;
        this.columnNames = colTitles;
        this.dataStrings = dataStrings;
    }

    public void setTableValues(String[][] dataStrings) {
        this.dataStrings = dataStrings;
    }

    // Returns a constant columns number for this model
    public int getColumnCount() {
        return columns;
    }

    // Returns the number of files in directory
    public int getRowCount() {
        return rows;
    }

    // Returns the name of the given column index
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return dataStrings[row][col];
    }

}
