package MenuComponents;

import GameObjects.Score;

import javax.swing.*;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;

public class ScoreListModel extends AbstractListModel {

    public List<Score> scores;

    public ScoreListModel(List<Score> scores){
        this.scores = scores;
        Collections.sort(this.scores);
    }

    @Override
    public int getSize() {
        return scores.size();
    }

    @Override
    public Object getElementAt(int index) {
        Score score = scores.get(index);
        String align = "     ";

        String indexString = index+1 + ".";
        for (int i = indexString.length(); i < 5; i++){
            indexString += " ";
        }

        String NameString = score.Name;
        for (int i = NameString.length(); i < 20; i++){
            NameString += " ";
        }

        String PointString = Integer.toString(score.Score);

        return align + indexString + NameString + PointString;
    }
}
