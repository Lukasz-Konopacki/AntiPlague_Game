package MenuComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ScorePanel extends JPanel{
    public ScorePanel(Iwindow window){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel LLogo = new LogoLabel("High Scores" , 80);
        JButton bBack = new MenuButton ("Back");
        bBack.addActionListener(e -> {
            window.SwitchPanel("Menu");
        });

        this.add(Box.createRigidArea(new Dimension(0, 100)));
        this.add(LLogo);
        this.add(Box.createRigidArea(new Dimension(0, 100)));
        this.add(bBack);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
    }
}
