package MenuComponents;

import GameObjects.Country;
import GameObjects.Stats;
import GameObjects.Upgrade;

import javax.swing.*;
import java.awt.*;

public class UpgradeButton extends JButton {
    public Country country;
    private Upgrade upgrade;
    public Stats stats;

    public UpgradeButton(Country country, int UpgradeNumber, Stats stats){
        super();
        this.upgrade = country.upgrades.get(UpgradeNumber);
        this.stats = stats;
        this.setText(upgrade.Name);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setBackground(Color.WHITE);
        this.setMaximumSize(new Dimension(300, 80));
        this.setMinimumSize(new Dimension(300, 80));
        this.setFont(new Font("VT323", Font.PLAIN, 24));
        this.setForeground(Color.decode("#6382bf"));
        this.setBorder(BorderFactory.createLineBorder(Color.decode("#6382bf"), 2));
        this.setFocusable(false);
        this.country = country;
        addActionListener(e -> {
            event();
        });
    }

    public void event(){
        this.upgrade.Effect(country, this, stats);
    }

    public void setUpgrade(Country country, int UpgradeNumber) {
        this.upgrade = country.upgrades.get(UpgradeNumber);
        this.setText(upgrade.Name);
        this.country = country;
    }
}
