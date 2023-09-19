package MenuComponents;

import GameObjects.Score;
import GameObjects.Stats;
import Others.FileManager;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class SaveScoreWindow extends JFrame {
    public static boolean IsOpen = false;

    public SaveScoreWindow(JFrame GameFrame, Stats stats){
        this.requestFocus();
        IsOpen = true;
        setSize(400, 280);
        setLocation(((1280 - 400) /2),(720 - 400)/2);
        setIconImage(new ImageIcon("img/score.png").getImage());
        setTitle("Quit Game");
        setResizable(false);
        setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                IsOpen = false;
                dispose();
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("<html><div style='text-align: center;'>Write down your name to save the score and exit the game</div></html>");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setDocument(new UserTextFieldLimit(20));
        textField.setBackground(null);
        textField.setMaximumSize(new Dimension(300, 80));
        textField.setMinimumSize(new Dimension(300, 80));
        textField.setFont(new Font("VT323", Font.PLAIN, 36));
        textField.setForeground(Color.decode("#6382bf"));
        textField.setBorder(BorderFactory.createLineBorder(Color.decode("#6382bf"), 2));

        JLabel errorText = new JLabel(" ");
        errorText.setAlignmentX(Component.CENTER_ALIGNMENT);
        errorText.setForeground(Color.red);

        JButton button = new MenuButton("Save and exit");
        button.setMaximumSize(new Dimension(200, 50));
        button.setMinimumSize(new Dimension(200, 50));
        button.setFont(new Font("VT323", Font.PLAIN, 24));
        button.addActionListener(e -> {
            if (textField.getText().trim().length() > 0){
                textField.setText(textField.getText().trim());

                Score score = new Score(textField.getText(), stats.Score);
                FileManager.SaveScore(score);

                MenuWindow.Create();
                GameFrame.dispose();
                dispose();
            }
            else {
                errorText.setText("You must type your name!");
            }
        });

        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(errorText);
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(button);
        add(panel);
    }
}
