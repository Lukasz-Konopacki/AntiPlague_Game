package Others;

import GameObjects.Country;

import javax.swing.*;

public class VaccineThreat extends Thread{
    private JButton button;
    private Country country;

    public VaccineThreat(Country country, JButton button){
        this.country = country;
        this.button = button;
    }

    @Override
    public void run() {
        try{
            for (int i =180; i > 0; i--)
            {
                sleep(1000);
                int min = i / 60;
                int sec = i%60;
                country.upgrades.get(0).Name =  (min + "m" + sec + "s");
            }
            country.upgrades.get(0).Name = "Vaccinating people!";
            country.isStartVaccinating = true;
            while (country.contagiousnessLvl >= 0.01){
                country.contagiousnessLvl -= country.contagiousnessLvl/10;
                sleep(1000);
            }
        }
        catch (InterruptedException e){
            System.out.println("Problem with VaccineThreat! pleas report developer about this problem");
        }
    }
}
