package GameObjects;

import javax.swing.*;

public class QuarantineUpgrade extends Upgrade{
    public QuarantineUpgrade() {
        super("<html><div style='text-align: center;'>Quarantine<br>$" + 500 + "</div></html>",
                "Enter country-wide quarantines",
                500);
    }

    @Override
    public void Effect(Country country, JButton button, Stats stats) {
        if (!isBuy && stats.Money > cost){
            stats.Money -= cost;
            country.contagiousnessLvl -= 2;
            this.Name = "Quarantine!";
            isBuy = true;
        }
    }
}
