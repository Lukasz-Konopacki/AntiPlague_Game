package GameObjects;

import Others.VaccineThreat;

import javax.swing.*;
import java.util.Map;

public class BuyVaccineUpgrade extends Upgrade{
    private Map<String, Country> countries;

    public BuyVaccineUpgrade(Map<String,Country> countries) {
        super("<html><div style='text-align: center;'>Vaccine research<br>$" + 300 + "</div></html>"
                , "If a country has invented a vaccine, you will be able to buy it", 300);
        this.countries = countries;
    }

    @Override
    public void Effect(Country country, JButton button, Stats stats) {
        if (!isBuy && stats.Money > cost){
            for (Country countryCheck : countries.values()){
                if (countryCheck.isStartVaccinating){
                    isBuy = true;
                    stats.Money -= cost;
                    VaccineThreat vt = new VaccineThreat(country,button);
                    vt.start();
                    return;
                }
            }
        }
    }
}
