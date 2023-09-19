package GameObjects;

import javax.swing.*;

public class MasksUpgrade extends Upgrade{

    public MasksUpgrade() {
        super("<html><div style='text-align: center;'>Wear masks<br>$" + 100 + "</div></html>",
                "make people wear masks",
                100);
    }

    @Override
    public void Effect(Country country, JButton button, Stats stats) {
        if (!isBuy && stats.Money > cost){
            stats.Money -= cost;
            country.contagiousnessLvl -= 1;
            this.Name = "people wear masks";
            isBuy = true;
        }
    }
}
