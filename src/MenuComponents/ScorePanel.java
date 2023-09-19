package MenuComponents;

import GameObjects.Score;
import Others.FileManager;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.metal.MetalScrollBarUI;
import java.awt.*;
import java.util.List;

public class ScorePanel extends JPanel{
    public ScorePanel(MenuWindow window){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        JLabel LLogo = new LogoLabel("High Scores" , 80);

        JButton bBack = new MenuButton ("Back");
        bBack.addActionListener(e -> {
            window.SwitchPanel("Menu");
        });

        List<Score> scores =  FileManager.LoadScore();
        ScoreListModel scoreListModel = new  ScoreListModel(scores);
        JList scoreList = new JList(scoreListModel);
        scoreList.setCellRenderer(new ScoreListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(scoreList);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.decode("#6382bf"), 2));
        scrollPane.setForeground(Color.decode("#6382bf"));

        scrollPane.setMaximumSize(new Dimension(400, 500));
        scrollPane.setMinimumSize(new Dimension(400, 500));

        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(LLogo);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(scrollPane);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(bBack);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
    }
}
