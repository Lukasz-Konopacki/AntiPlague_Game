package GameObjects;

import javax.swing.*;

public class CleaningUpgrade extends Upgrade{
    public CleaningUpgrade() {
        super("<html><div style='text-align: center;'>Cleaning agents<br>$" + 200 + "</div></html>",
                "Convince people to be more clean and cautious",
                200);
    }

    @Override
    public void Effect(Country country, JButton button, Stats stats) {
        if (!isBuy && stats.Money > cost){
            stats.Money -= cost;
            country.contagiousnessLvl -= 0.5;
            this.Name = "Cleaning supplies provided";
            isBuy = true;
        }
    }
}
