package GameObjects;

import javax.swing.*;

public abstract class Upgrade {
    public String Name;
    public String Description;
    public int cost;
    public boolean isBuy;
    public Country country;

    public Upgrade(String Name, String Description, int cost){
        this.Name = Name;
        this.Description = Description;
        this.cost = cost;
        this.isBuy = false;
    }

    public abstract void Effect(Country country, JButton button, Stats stats);
}
