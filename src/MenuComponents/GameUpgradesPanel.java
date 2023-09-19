package MenuComponents;

import GameObjects.Country;
import GameObjects.Stats;

import javax.swing.*;
import java.awt.*;

public class GameUpgradesPanel extends JPanel {
    public JLabel CountryName;
    public JLabel CountryFlag;
    public JLabel Alive;
    public JLabel infected;
    public JLabel death;
    public JLabel recovered;
    public JLabel Points;
    public JLabel Time;
    public JLabel Money;
    public UpgradeButton UpgradeButton1;
    public UpgradeButton UpgradeButton2;
    public UpgradeButton UpgradeButton3;
    public UpgradeButton UpgradeButton4;
    private  Country actualCountry;


    public GameUpgradesPanel(Stats stats, Country startCountry){
        actualCountry = startCountry;
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        Points = new JLabel(String.valueOf(stats.Score));
        Points.setIcon(new ImageIcon("img/Point.png"));
        Time = new JLabel(String.valueOf(stats.Time));
        Time.setIcon(new ImageIcon("img/Time.png"));
        Money = new JLabel(String.valueOf(stats.Money));
        Money.setIcon(new ImageIcon("img/Money.png"));
        Money.setHorizontalAlignment(JLabel.CENTER);
        Time.setHorizontalAlignment(JLabel.CENTER);;
        Points.setHorizontalAlignment(JLabel.CENTER);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(Points, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        add(Time, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        add(Money, c);


        CountryFlag = new JLabel();
        CountryFlag.setIcon(startCountry.flag);
        CountryFlag.setPreferredSize(new Dimension(100, 100));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,20,15,20);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        add(CountryFlag, c);


        CountryName = new JLabel(startCountry.name);
        CountryName.setHorizontalAlignment(JLabel.LEFT);
        CountryName.setFont(new Font("VT323", Font.BOLD, 40));
        CountryName.setPreferredSize(new Dimension(130, 100));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,20,15,20);
        c.gridx = 1;
        c.gridy = 2;

        add(CountryName, c);

        Alive = new JLabel("No contact: " + startCountry.noContact);
        Alive.setHorizontalAlignment(JLabel.LEFT);
        Alive.setFont(new Font("VT323", Font.BOLD, 16));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,10,0,0);
        c.gridx = 0;
        c.gridy = 3;
        add(Alive, c);

        death = new JLabel("Death: " + startCountry.death);
        death.setHorizontalAlignment(JLabel.LEFT);
        death.setFont(new Font("VT323", Font.BOLD, 16));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,20,0,0);
        c.gridx = 1;
        c.gridy = 3;
        add(death, c);

        infected = new JLabel("infected: " + startCountry.infected);
        infected.setHorizontalAlignment(JLabel.LEFT);
        infected.setFont(new Font("VT323", Font.BOLD, 16));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,10,0,0);
        c.gridx = 0;
        c.gridy = 4;
        add(infected, c);

        recovered = new JLabel("recovered: " + startCountry.recovered);
        recovered.setHorizontalAlignment(JLabel.LEFT);
        recovered.setFont(new Font("VT323", Font.BOLD, 16));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,20,0,0);
        c.gridx = 1;
        c.gridy = 4;
        add(recovered, c);

        UpgradeButton1 = new UpgradeButton(startCountry, 0,stats);
        c.insets = new Insets(20,0,2,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;      //make this component tall
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 5;
        add(UpgradeButton1, c);

        UpgradeButton2 = new UpgradeButton(startCountry, 1, stats);
        c.insets = new Insets(2,0,2,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;      //make this component tall
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 6;
        add(UpgradeButton2, c);

        UpgradeButton3 = new UpgradeButton(startCountry, 2, stats);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;      //make this component tall
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 7;
        add(UpgradeButton3, c);

        UpgradeButton4 = new UpgradeButton(startCountry, 3, stats);
        c.insets = new Insets(2,0,25,0);  //top padding
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;      //make this component tall
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 8;
        add(UpgradeButton4, c);

        JLabel shortcut = new JLabel("Ctrl + Q - Quit game and save score");
        shortcut.setHorizontalAlignment(JLabel.CENTER);
        shortcut.setFont(new Font("VT323", Font.BOLD, 16));
        c.insets = new Insets(2,0,25,0);  //top padding
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;      //make this component tall
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 9;
        add(shortcut, c);
    }

    public void setCountry(Country country){
        actualCountry = country;
        this.CountryFlag.setIcon(actualCountry.flag);
        this.CountryName.setText(country.name);
        updateCountryStats();

        UpgradeButton1.setUpgrade(country, 0);
        UpgradeButton2.setUpgrade(country, 1);
        UpgradeButton3.setUpgrade(country, 2);
        UpgradeButton4.setUpgrade(country, 3);
    }

    public void updateCountryStats(){
        Alive.setText("No Contact: " + actualCountry.noContact);
        infected.setText("Infected: " + actualCountry.infected);
        death.setText("Death: " + actualCountry.death);
        recovered.setText("Recovered: " + actualCountry.recovered);
        if (actualCountry.upgrades.get(0).isBuy){
            UpgradeButton1.setForeground(Color.green);
        }
        else{
            UpgradeButton1.setForeground(Color.decode("#6382bf"));
        }
        if (actualCountry.upgrades.get(1).isBuy){
            UpgradeButton2.setForeground(Color.green);
        }
        else{
            UpgradeButton2.setForeground(Color.decode("#6382bf"));
        }
        if (actualCountry.upgrades.get(2).isBuy){
            UpgradeButton3.setForeground(Color.green);
        }
        else{
            UpgradeButton3.setForeground(Color.decode("#6382bf"));
        }
        if (actualCountry.upgrades.get(3).isBuy){
            UpgradeButton4.setForeground(Color.green);
        }
        else{
            UpgradeButton4.setForeground(Color.decode("#6382bf"));
        }
        UpgradeButton1.setText(actualCountry.upgrades.get(0).Name);
        UpgradeButton2.setText(actualCountry.upgrades.get(1).Name);
        UpgradeButton3.setText(actualCountry.upgrades.get(2).Name);
        UpgradeButton4.setText(actualCountry.upgrades.get(3).Name);
    }

    public void setStats(Stats stats){
        this.Points.setText(String.valueOf(stats.Score));
        this.Time.setText(String.valueOf(stats.Time));
        this.Money.setText(String.valueOf(stats.Money));
    }

}
