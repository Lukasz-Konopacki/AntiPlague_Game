package GameObjects;

import javax.swing.*;

public class FinanceUpgrade extends Upgrade{
    public FinanceUpgrade() {
        super("<html><div style='text-align: center;'>Subsidize hospitals<br>$" + 200 + "</div></html>",
                "Increase the amount of money spent on hospitals",
                200);
    }

    @Override
    public void Effect(Country country, JButton button, Stats stats) {
        if (!isBuy && stats.Money > cost){
            stats.Money -= cost;
            country.curabilityLvl += 0.2;
            this.Name = "Hospitals treat more people!";
            isBuy = true;
        }
    }
}
