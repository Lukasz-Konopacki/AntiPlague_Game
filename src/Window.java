import MenuComponents.Iwindow;
import MenuComponents.MenuPanel;
import MenuComponents.ScorePanel;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Iwindow {
    private static boolean isCreated = false;
    private final CardLayout cLayout;
    private final JPanel mainPane;

    private Window(){
        setSize(600,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setIconImage(new ImageIcon("img/virus.png").getImage());
        setTitle("Anti Plague");
        setResizable(false);

        cLayout = new CardLayout();
        mainPane = new JPanel(cLayout);
        add(mainPane);
        isCreated = true;
    }

    public static Window Create(){
        if (isCreated == false){
            Window window = new  Window();
            window.mainPane.add("Menu", new MenuPanel(window));
            window.mainPane.add("HighScore", new ScorePanel(window));

            return window;
        }
        else {
            throw new RuntimeException("You can't create second Window object");
        }
    }

    @Override
    public void SwitchPanel(String panel) {
        cLayout.show(mainPane, panel);
    }
}
