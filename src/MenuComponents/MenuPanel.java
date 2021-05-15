package MenuComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel{
    public MenuPanel(Iwindow window){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel LLogo = new LogoLabel("Anti Plague", 100);
        JButton bNewGame = new MenuButton("New Game");
        System.out.println(this.paramString());
        bNewGame.addActionListener(e -> {
            window.SwitchPanel("NewGame");
        });
        JButton bHighScores = new MenuButton ("High Scores");
        bHighScores.addActionListener(e -> {
            window.SwitchPanel("HighScore");
        });
        JButton bExit = new MenuButton("Exit");
        bExit.addActionListener(e -> {
            window.dispose();
        });

        this.add(Box.createRigidArea(new Dimension(0, 100)));
        this.add(LLogo);
        this.add(Box.createRigidArea(new Dimension(0, 100)));
        this.add(bNewGame);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(bHighScores);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(bExit);
    }

}
