package MenuComponents;

import javax.swing.*;
import java.awt.*;

public class ScoreListCellRenderer extends JLabel implements ListCellRenderer{
    ScoreListCellRenderer(){
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        setText((String)value);

        return this;
    }
}
