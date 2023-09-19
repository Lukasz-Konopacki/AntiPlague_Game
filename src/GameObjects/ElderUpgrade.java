package GameObjects;

import javax.swing.*;

public class ElderUpgrade extends Upgrade{
    public ElderUpgrade() {
        super("<html><div style='text-align: center;'>Help for the elderly<br>$" + 100 + "</div></html>",
                "Get people involved to help the older person",
                100);
    }

    @Override
    public void Effect(Country country, JButton button, Stats stats) {
        if (!isBuy && stats.Money > cost){
            stats.Money -= cost;
            country.mortalityLvl -= 0.1;
            this.Name = "Elderly stay home!";
            isBuy = true;
        }
    }
}
