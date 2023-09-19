package MenuComponents;

import GameObjects.DifficultyLvl;

import javax.swing.*;
import java.awt.*;

public class DifficultyLvlPanel extends JPanel{

    public DifficultyLvlPanel(MenuWindow window){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel LLogo1 = new LogoLabel("Difficulty" , 80);
        JLabel LLogo2 = new LogoLabel("Level" , 80);

        JButton Easy = new MenuButton("Easy");
        Easy.addActionListener(e -> {
           new GameWindow(new DifficultyLvl(1));
           window.dispose();
        });
        JButton Normal = new MenuButton ("Normal");
        Normal.addActionListener(e -> {
            new GameWindow(new DifficultyLvl(2));
            window.dispose();
        });
        JButton Hard = new MenuButton("Hard");
        Hard.addActionListener(e -> {
            new GameWindow(new DifficultyLvl(3));
            window.dispose();
        });

        this.add(Box.createRigidArea(new Dimension(0, 100)));
        this.add(LLogo1);
        this.add(LLogo2);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(Easy);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(Normal);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(Hard);
    }


}
