package MenuComponents;

import GameObjects.Country;

import javax.swing.*;
import java.awt.*;

public class CountryButton extends JButton{

    public CountryButton(Country country, GameUpgradesPanel upgradesPanel){
        super(country.name);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setOpaque(true);
        this.setBackground(Color.decode(country.color));
        this.setBorderPainted(false);
        this.setMaximumSize(new Dimension(300, 80));
        this.setMinimumSize(new Dimension(300, 80));
        this.setFont(new Font("VT323", Font.PLAIN, 16));
        this.setForeground(Color.black);
        this.setFocusable(false);
        this.setBounds(country.xMap-50, country.yMap-20, 100, 40);
        addActionListener(e -> {
            upgradesPanel.setCountry(country);
        });
    }
}
