package Model;
//TODO

//Skriv de metoder som anropas av Controller-klassen och som saknas här

//Schedule to keep track of the of the name of hours in a scheduled task.
// In this version, the schedule works only for one year.
// TotNumofRows = number of days in the chosen month.
// The number of days is calculted for the leap years.
// It should be calculated everytime to make sure the value
// is updated as the user changes the month on the GUI
//
public class Schedule {
    private final int totNumOfCols = 12; // months of the year
    private final int totNumOfRows = 31; // days of months

    // two-dim array for storing number of hrs per week
    private double[][] timeReport;

    // Default Constructor
    // Initialize date to today.
    public Schedule() {
        // CreateTable
        timeReport = new double[totNumOfRows][totNumOfCols];
    }

    // TODO created gettimereport table is DONEEEEEE
    public String[][] getTimeReportTable() {
        String[][] tmp = new String[totNumOfRows][totNumOfCols];

        for (int i = 0; i < totNumOfRows; i++) {
            for (int j = 0; j < totNumOfCols; j++) {
                tmp[i][j] = String.valueOf(timeReport[i][j]);
            }
        }

        return tmp;
    }

    // TODO return amount of days per month
    public int getNumOfRows() {
        return totNumOfRows;
    }

    // TODO return amount of colomns as in day then the months basically Day + the
    // 12 months
    public int getNumOfCols() {
        return totNumOfCols;
    }

    // TODO should be called for when switching month so it calculate days for that
    // month
    // Calculates the number of days in a given month,for a given year.
    // If the year is a leap year, days in feb will be 29.
    // The number of days for the given mnh and year.</returns>
    public int calculateDays(MonthsOfYear month, int year) {
        switch (month) {
            // jan, march,may,july,oct & dec
            case Jan:
            case Mar:
            case May:
            case Jul:
            case Aug:
            case Oct:
            case Dec:
                return 31; // break or return can be used

            case Feb: // february
                if (isLeapYear(year))
                    return 29;
                else
                    return 28;

            case Apr:
            case Jun:
            case Sep:
            case Nov: // apr, jun, sep,nov
                return 30;

            default:

                return 31;
        }

    }

    public String[] getDayNames() {
        // days of a month
        String[] days = new String[totNumOfRows];

        for (int i = 0; i < totNumOfRows; i++) {
            days[i] = String.format("%2d", i + 1); // "
        }
        return days;
    }

    public void setNewValueInTable(int day, int month, double value) {
        if (day < calculateDays(MonthsOfYear.values()[month], 2021) && value <= 24.0)
            timeReport[day][month] = value;
    }

    public String[] getTableColumnStrings() {
        // TODO: TEMP FIX
        String[] tmp = new String[MonthsOfYear.values().length];
        for (int i = 0; i < tmp.length; i++) {

            tmp[i] = MonthsOfYear.values()[i].toString();
        }

        return tmp;
    }

    public double getTotalHoursYear() {
        double sum = 0;
        for (double[] ds : timeReport) {
            for (double d : ds) {
                sum += d;
            }
        }

        return sum;
    }

    public double getTotalHoursMonth(int month) {
        double sum = 0;

        for (int i = 0; i < calculateDays(MonthsOfYear.values()[month], 2020); i++) {
            sum += timeReport[i][month];
        }

        return sum;
    }

    // A year will be a leap year if it is divisible by 4 but not by 100.
    // If a year is divisible by 4 and by 100, it is not a leap year unless
    // it is also divisible by 400.
    private boolean isLeapYear(int year) {
        boolean leapYear;
        leapYear = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
        return leapYear;
    }

}
