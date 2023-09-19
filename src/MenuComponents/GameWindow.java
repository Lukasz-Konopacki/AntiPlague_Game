package MenuComponents;

import GameObjects.DifficultyLvl;
import GameObjects.Stats;
import Others.GameThreat;
import Others.InitGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JFrame implements  KeyListener{
    private DifficultyLvl difficultyLvl;
    private JPanel panel;
    private BorderLayout layout;
    private Stats stats;


    public GameWindow(DifficultyLvl difficultyLvl){
        this.difficultyLvl = difficultyLvl;
        setSize(1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setIconImage(new ImageIcon("img/icon.png").getImage());
        setTitle("Anti Plague");
        addKeyListener(this);
        setLayout(new BorderLayout());
        requestFocus();

        InitGame initGame = new InitGame(difficultyLvl);
        GameUpgradesPanel Upgrades = new GameUpgradesPanel(initGame.stats, initGame.startCountry);
        GameMapPanel map = new GameMapPanel(initGame.countries, Upgrades, initGame.transports);
        GameThreat gt = new GameThreat(Upgrades, map, initGame.countries, initGame.stats, initGame.startCountry, initGame.transports, this);
        gt.start();
        stats = initGame.stats;

        add(Upgrades, BorderLayout.LINE_END);
        add(map, BorderLayout.CENTER);
        //add(new GameInfoBar(), BorderLayout.PAGE_START);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == e.VK_Q && e.isControlDown()) {
            if (!SaveScoreWindow.IsOpen){
                new  SaveScoreWindow(this, stats);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
