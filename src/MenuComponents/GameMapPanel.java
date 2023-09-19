package MenuComponents;

import GameObjects.Country;
import GameObjects.Transport;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.Timer;

public class GameMapPanel extends JPanel {
    private Image img;
    private List<Transport> transports;

    public GameMapPanel(Map<String, Country> countries, GameUpgradesPanel upgradesPanel, List<Transport> transports){
        setLayout(null);

        CountryButton BPoland = new CountryButton(countries.get("Poland"), upgradesPanel);
        CountryButton BFrance = new CountryButton(countries.get("France"),upgradesPanel);
        CountryButton BEngland = new CountryButton(countries.get("England"), upgradesPanel);
        CountryButton BSpain = new CountryButton(countries.get("Spain"),upgradesPanel);
        CountryButton BGermany = new CountryButton(countries.get("Germany"),upgradesPanel);
        CountryButton BSweden = new CountryButton(countries.get("Sweden"),upgradesPanel);
        CountryButton BItaly = new CountryButton(countries.get("Italy"),upgradesPanel);
        CountryButton BGreece = new CountryButton(countries.get("Greece"), upgradesPanel);
        CountryButton BRomania = new CountryButton(countries.get("Romania"),upgradesPanel);
        CountryButton BUkraine = new CountryButton(countries.get("Ukraine"),upgradesPanel);

        add(BPoland);
        add(BFrance);
        add(BEngland);
        add(BSpain);
        add(BGermany);
        add(BSweden);
        add(BItaly);
        add(BGreece);
        add(BRomania);
        add(BUkraine);

        this.transports = transports;
        img = new  ImageIcon("img/europe_map.jpg").getImage();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;
        for (Transport transport: transports) {
            if (transport.IsWorking){
                g2D.drawImage(transport.transportIcon, (int)transport.x, (int)transport.y, null);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0,this.getWidth(),this.getHeight(), null);
    }

}

