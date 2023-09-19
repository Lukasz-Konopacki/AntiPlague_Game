package GameObjects;

import javax.swing.*;

public class TaxesUpgrade extends Upgrade{
    public TaxesUpgrade() {
        super("<html><div style='text-align: center;'>Increase taxes<br>$" + 100 + "</div></html>",
                "The gold output speed will increase, but the virus will progress faster",
                100);
    }

    @Override
    public void Effect(Country country, JButton button, Stats stats) {
        if (!isBuy && stats.Money > cost){
            stats.Money -= cost;
            country.taxLvl += 3;
            country.contagiousnessLvl += 1;
            this.Name = "income increased!";
            isBuy = true;
        }
    }
}
