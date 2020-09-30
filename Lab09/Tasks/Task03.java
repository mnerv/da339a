package Tasks;

public class Task03 extends Task {

    @Override
    public void Run() {
        // @formatter:off
        String[][] students = { 
        // . Firstname, Lastname, Date,  points, grade  
            { "Adam",   "Ason",  "661122", "35", "U" }, 
            { "Beata",  "Bson",  "770111", "38", "G" },
            { "Calle",  "Ceson", "880222", "23", "U" }, 
            { "Dorotea","Deson", "990311", "44", "VG"},
            { "Eivar",  "Eson",  "550423", "40", "G" } 
        };
        // @formatter:on

        // Task03a
        System.out.println("Task03a\n");
        for (int i = 0; i < students.length; i++) {
            if (students[i][4] == "G" || students[i][4] == "VG") {
                System.out.printf("%s \t %s\n", students[i][1], students[i][4]);
            }
        }

        // TODO: Task03b fix the array
        HDiv();
        System.out.println("Task03a");
        for (int i = 0; i < students.length; i++) {
            int points = Integer.parseInt(students[i][3]);
            if (points >= 25) {
                System.out.printf("%s \t %s\n", students[i][1], points >= 25 && points < 40 ? "G" : "VG");
            }
        }

    }

}
