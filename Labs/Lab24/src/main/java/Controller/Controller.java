package Controller;

import Model.MonthsOfYear;
import Model.Schedule;
import View.MainFrame;

public class Controller {
    private MainFrame view;
    private Schedule schedule;

    public Controller() {
        schedule = new Schedule();
        view = new MainFrame(this);
    }

    public String[][] getTableData() {
        String[][] tableData = schedule.getTimeReportTable();
        return tableData;
    }

    private void updateView() {
        String[][] tableData = schedule.getTimeReportTable();
        view.updateTableData(tableData);
    }

    // TODO
    // metoden skall returnera antalet dagar (31)
    public int getNumOfTableRows() {
        return schedule.getNumOfRows(); // dagar i månaden
    }

    // TODO
    // Metoden skall returnera antalet kolumner ("Day", "Jan", "Feb"...)
    public int getNumOfTableColumns() {
        return schedule.getNumOfCols(); // Day + 12 månader
    }

    public void setHours(int month, int day, double value) {
        schedule.setNewValueInTable(month, day, value);
        updateView();
    }

    // TodDo
    // Metoden skall returnera en array av stränger
    // "Day", "Jan", "Feb", ....
    public String[] getColTitles() {
        String[] columnNames = schedule.getTableColumnStrings();
        return columnNames;
    }

    public String[] getMonthStrings() {
        String[] tmp = new String[MonthsOfYear.values().length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = MonthsOfYear.values()[i].toString();
        }

        return tmp;
    }

    public String[] getDayStrings() {
        return schedule.getDayNames();
    }

    // Komplettera med andra metoder som kan behövas.

}
