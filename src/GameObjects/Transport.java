package GameObjects;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Transport {
    public String name;
    public Country FirstCountry;
    public Country SecondCountry;
    public Image transportIcon;
    public boolean IsWorking;
    public double x;
    public double y;
    public int infectedPeople;
    private Random random;
    private Image[] icons;

    public Transport(Country FirstCountry,Country SecondCountry){
        random = new Random();
        icons = new Image[]{new ImageIcon("img/airPlane.png").getImage(), new ImageIcon("img/car1.png").getImage(),new ImageIcon("img/car2.png").getImage()};
        transportIcon = icons[random.nextInt(3)];
        this.FirstCountry = FirstCountry;
        this.SecondCountry = SecondCountry;
        this.x = FirstCountry.xMap;
        this.y = FirstCountry.yMap;
        this.IsWorking = true;
        if(FirstCountry.infected > 100 && random.nextBoolean()){
            infectedPeople = 2;
        }
    }

    public void UpdateTransport(){
        double directionX = ((SecondCountry.xMap - FirstCountry.xMap)/Math.abs(SecondCountry.xMap - FirstCountry.xMap));
        double directionY = ((SecondCountry.yMap - FirstCountry.yMap)/Math.abs(SecondCountry.yMap - FirstCountry.yMap));

        double distance = Math.sqrt(Math.pow((SecondCountry.xMap - FirstCountry.xMap),2)  + Math.pow((SecondCountry.yMap - FirstCountry.yMap),2));

        x += 3* directionX * Math.abs(SecondCountry.xMap - FirstCountry.xMap) / distance;
        y += 3* directionY * Math.abs(SecondCountry.yMap - FirstCountry.yMap) / distance;

        if (directionX > 0 && x >= SecondCountry.xMap || directionX < 0 && x <= SecondCountry.xMap)
        {
            SecondCountry.infected += infectedPeople;
            Country buff = FirstCountry;
            FirstCountry = SecondCountry;
            SecondCountry = buff;
            transportIcon = icons[random.nextInt(3)];
            if(FirstCountry.infected > 100 && random.nextBoolean()){
                infectedPeople = 2;
            }
        }
    }

}
