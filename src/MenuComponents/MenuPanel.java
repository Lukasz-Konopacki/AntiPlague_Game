package MenuComponents;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel{
    public MenuPanel(MenuWindow window){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel LLogo = new LogoLabel("Anti Plague", 100);

        JButton bNewGame = new MenuButton("New Game");
            bNewGame.addActionListener(e -> window.SwitchPanel("NewGame"));
        JButton bHighScores = new MenuButton ("High Scores");
            bHighScores.addActionListener(e -> window.SwitchPanel("HighScore"));
        JButton bExit = new MenuButton("Exit");
            bExit.addActionListener(e -> window.dispose());

        ImageIcon image = new ImageIcon("img/icon.png");
        JLabel label = new JLabel("", image, JLabel.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createRigidArea(new Dimension(0, 25)));
        this.add(LLogo);
        this.add(label);
        this.add(Box.createRigidArea(new Dimension(0, 25)));
        this.add(bNewGame);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(bHighScores);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(bExit);
    }

}
