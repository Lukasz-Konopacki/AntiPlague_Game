package MenuComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuButton extends JButton {

    public  MenuButton(String text){
        super(text);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setBackground(Color.WHITE);
        this.setMaximumSize(new Dimension(300, 80));
        this.setMinimumSize(new Dimension(300, 80));
        this.setFont(new Font("VT323", Font.PLAIN, 36));
        this.setForeground(Color.decode("#6382bf"));
        this.setBorder(BorderFactory.createLineBorder(Color.decode("#6382bf"), 2));
        this.setFocusable(false);
    }
}
