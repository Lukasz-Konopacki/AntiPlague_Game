package Others;

import GameObjects.Country;
import GameObjects.Stats;
import GameObjects.Transport;
import MenuComponents.GameMapPanel;
import MenuComponents.GameUpgradesPanel;
import MenuComponents.GameWindow;
import MenuComponents.SaveScoreWindow;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameThreat extends Thread{
    public Map<String,Country> countries;
    public boolean GameOver;
    public GameUpgradesPanel upgradesPanel;
    public GameMapPanel mapPanel;
    public Stats stats;
    public List<Transport> transports;
    private int TimeCounter;
    private GameWindow gameWindow;

    public GameThreat(GameUpgradesPanel upgradesPanel, GameMapPanel mapPanel, Map<String, Country> countries, Stats stats, Country startCountry, List<Transport> transports, GameWindow gm){
        this.upgradesPanel = upgradesPanel;
        this.mapPanel = mapPanel;
        this.countries = countries;
        this.GameOver = false;
        this.stats = stats;
        this.transports = transports;
        this.gameWindow = gm;

        startCountry.infected = 2;
    }

    public void run(){

        while (!GameOver){
            try{
                int end =0;
                while (TimeCounter < 15){
                    TimeCounter++;
                    sleep(50);
                    upgradesPanel.updateCountryStats();
                    for (Transport transport: transports) {
                        transport.UpdateTransport();
                    }
                    mapPanel.repaint();
                }
                TimeCounter = 0;
                int newMoney = 0;
                stats.Score = 0;
                for (Country country: countries.values() ) {
                    newMoney += country.taxLvl;
                    stats.Score += country.recovered;
                    if (country.noContact == 0 && country.infected == 0){
                        end++;
                    }
                }
                stats.UpdateStat(0,newMoney,1);
                upgradesPanel.setStats(stats);
                spreadVirus();
                if (end == countries.size()){
                    GameOver = true;
                }
            }
            catch (InterruptedException e){
                System.out.println("Game threat error, the game stop working");
            }
        }
        if (GameOver){
            if (!SaveScoreWindow.IsOpen){
                new  SaveScoreWindow(gameWindow, stats);
            }
        }
    }

    public void spreadVirus(){
        for (Country country: countries.values()) {
            if (country.infected > 0){

                int newInfected = (int) ((country.infected) * country.contagiousnessLvl  + 1);
                if (newInfected <= country.noContact){
                    int newRecovered = (int)(country.infected *country.curabilityLvl);
                    int newDeath = (int)((country.infected * country.mortalityLvl));
                    country.recovered += newRecovered;
                    country.death += newDeath;
                    country.infected += newInfected;
                    country.infected -= newRecovered + newDeath;
                    country.noContact -= newInfected;
                }
                else
                {
                    int newRecovered = (int)(country.infected / 4) +1;
                    int newDeath = (int)(country.infected / 5);
                    country.infected += country.noContact;
                    country.noContact = 0;
                    country.recovered += newRecovered;
                    country.death += newDeath;
                    country.infected -= newRecovered + newDeath;
                }

            }
        }
    }
}
