package MenuComponents;

import javax.swing.*;
import java.awt.*;

public class GameInfoBar extends JPanel {
    public GameInfoBar(){
        setLayout(new FlowLayout());

        add(new JLabel("Kasa"));
        add(new JLabel("Czas"));
        add(new JLabel("Punkty"));
    }
}
