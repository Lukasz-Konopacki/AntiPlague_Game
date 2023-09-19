package MenuComponents;

import javax.swing.*;
import java.awt.*;

public class MenuWindow extends JFrame{
    private static boolean isCreated = false;
    private final CardLayout cLayout;
    private final JPanel mainPane;

    private MenuWindow(){
        setSize(600,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setIconImage(new ImageIcon("img/icon.png").getImage());
        setTitle("Anti Plague");
        setResizable(false);

        cLayout = new CardLayout();
        mainPane = new JPanel(cLayout);
        add(mainPane);
        isCreated = true;
    }

    public static MenuWindow Create(){
        if (isCreated == false){
            MenuWindow window = new MenuWindow();
            window.mainPane.add("Menu", new MenuPanel(window));
            window.mainPane.add("HighScore", new ScorePanel(window));
            window.mainPane.add("NewGame", new DifficultyLvlPanel(window));

            return window;
        }
        else {
            throw new RuntimeException("You can't create second Window object");
        }
    }

    public void SwitchPanel(String panel) {
        cLayout.show(mainPane, panel);
    }

    @Override
    public void dispose() {
        super.dispose();
        this.isCreated = false;
    }
}
