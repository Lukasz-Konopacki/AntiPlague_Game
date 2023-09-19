package GameObjects;

import javax.swing.*;

public class TestsUpgrade extends Upgrade{

    public TestsUpgrade() {
        super("<html><div style='text-align: center;'>Enter the tests<br>$" + 300 + "</div></html>",
                "Make mandatory tests for the presence of the disease",
                300);
    }

    @Override
    public void Effect(Country country, JButton button, Stats stats) {
        if (!isBuy && stats.Money > cost){
            stats.Money -= cost;
            country.curabilityLvl += 0.5;
            this.Name = "availability of tests!";
            isBuy = true;
        }
    }
}
