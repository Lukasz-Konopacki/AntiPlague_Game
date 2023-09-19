package GameObjects;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Country {
    public String name;
    public String color;
    public ImageIcon flag;
    public int xMap;
    public int yMap;

    public int noContact;
    public int death;
    public int infected;
    public int recovered;

    public int taxLvl;
    public double mortalityLvl;
    public double contagiousnessLvl;
    public double curabilityLvl;

    public boolean isStartVaccinating;

    public List<Upgrade> upgrades;

    public Country(String name, String color, ImageIcon flag, int people, int xMap, int yMap){
        this.name = name;
        this.color = color;
        this.flag = flag;
        this.upgrades = new ArrayList<>();

        this.xMap = xMap;
        this.yMap = yMap;

        this.noContact = people;
        this.death = 0;
        this.infected = 0;
        this.recovered = 0;
        this.taxLvl = 1;

        this.mortalityLvl = 0.005;
        this.contagiousnessLvl = 0.15;
        this.curabilityLvl = 0.01;

        this.isStartVaccinating = false;
    }
}
