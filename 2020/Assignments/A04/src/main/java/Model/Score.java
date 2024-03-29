package Model;

public class Score implements Comparable<Score> {
    private String name;
    private int score;

    public Score(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Score data) {
        return this.score - data.score;
    }
}
