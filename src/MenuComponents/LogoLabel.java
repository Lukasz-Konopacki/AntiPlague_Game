package MenuComponents;

import javax.swing.*;
import java.awt.*;

public class LogoLabel extends JLabel {
    public  LogoLabel(String text, int size){
        this.setText(text);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setFont(new Font("Virus 53X", Font.BOLD, size));
        this.setForeground(Color.decode("#596f93"));
    }
}
