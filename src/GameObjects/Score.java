package GameObjects;

public class Score implements Comparable<Score>{
    public String Name;
    public int Score;

    public Score(String Name,int Score){
        this.Name = Name;
        this.Score = Score;
    }

    @Override
    public String toString() {
        return Name + "     " + Score + "p";
    }

    @Override
    public int compareTo(Score o) {
        return o.Score - this.Score;
    }
}
