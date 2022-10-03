public class Print2DArrayA extends Task {
    @Override
    public String str() {
        return "Uppgift 3a Datautskrift";
    }

    @Override
    public void run() {
        for (int i = 0; i < students.length; ++i) {
            final var betyg = students[i][4];
            if (betyg.compareToIgnoreCase("G") == 0 || betyg.compareToIgnoreCase("VG") == 0) {
                System.out.print(students[i][1] + ", ");
                System.out.println(students[i][3]);
            }
        }
    }

    private static String[][] students = {
    //   Förnamn,   Efternamn, födelsedatum, poäng, betyg
        {"Adam",    "Ason",    "661122",     "35",  "U" },
        {"Beata",   "Bson",    "770111",     "38",  "G" },
        {"Calle",   "Ceson",   "880222",     "23",  "U" },
        {"Dorotea", "Deson",   "990311",     "44",  "VG"},
        {"Eivar",   "Eson",    "550423",     "40",  "G" }
    };
}

