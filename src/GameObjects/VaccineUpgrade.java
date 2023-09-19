package GameObjects;

import Others.VaccineThreat;

import javax.swing.*;

public class VaccineUpgrade extends Upgrade{

    public VaccineUpgrade() {
        super("<html><div style='text-align: center;'>Vaccine research<br>$" + 1000 + "</div></html>",
                        "Start researching the invention of a vaccine",
                1000);
    }

    @Override
    public void Effect(Country country, JButton button, Stats stats) {
        System.out.println(country.name);
        if (!isBuy && stats.Money > cost){
            stats.Money -= cost;
            isBuy = true;
            VaccineThreat vt = new VaccineThreat(country,button);
            vt.start();
        }
    }
}
