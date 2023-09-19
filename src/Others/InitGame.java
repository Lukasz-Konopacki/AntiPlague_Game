package Others;

import GameObjects.*;

import javax.swing.*;
import java.util.*;

public class InitGame {
    public Map<String, Country> countries = new Hashtable<String, Country>();
    public Stats stats = new Stats();
    public Country startCountry;
    public List<Transport> transports;

    public InitGame(DifficultyLvl difficultyLvl){
        countries = new Hashtable<>();
        countries.put("Poland", new Country("Poland", "#27767D",new ImageIcon("img/flags/Poland.png"),38536869, 640+50,230+20));
        countries.put("France", new Country("France", "#27767D",new  ImageIcon("img/flags/France.png"),62752136, 290+50,340+20));
        countries.put("England", new Country("England", "#DA6E48",new  ImageIcon("img/flags/England.png"),60609153, 240+50,180+20));
        countries.put("Spain", new Country("Spain", "#DA6E48",new  ImageIcon("img/flags/Spain.png"), 40397842, 100+50,470+20));
        countries.put("Germany", new Country("Germany", "#DA6E48",new  ImageIcon("img/flags/Germany.png"), 82422299, 470+50,250+20));
        countries.put("Sweden", new Country("Sweden", "#003344",new  ImageIcon("img/flags/Sweden.png"), 9016596,570+50,70+20));
        countries.put("Italy", new Country("Italy", "#003344",new  ImageIcon("img/flags/Italy.png"), 58133509, 490+50,480+20));
        countries.put("Greece", new Country("Greece", "#27767D",new  ImageIcon("img/flags/Greece.png"), 10688058, 720+50,580+20));
        countries.put("Romania", new Country("Romania", "#DA8549",new  ImageIcon("img/flags/Romania.png"), 22303552,770+50,400+20));
        countries.put("Ukraine", new Country("Ukraine", "#DA6E48",new  ImageIcon("img/flags/Ukraine.png") , 46710816, 820+50,290+20));

        List<Upgrade> pool1 = new ArrayList<Upgrade>();
        pool1.add(new VaccineUpgrade());
        pool1.add(new VaccineUpgrade());
        pool1.add(new VaccineUpgrade());
        pool1.add(new BuyVaccineUpgrade(countries));
        pool1.add(new BuyVaccineUpgrade(countries));
        pool1.add(new BuyVaccineUpgrade(countries));
        pool1.add(new BuyVaccineUpgrade(countries));
        pool1.add(new BuyVaccineUpgrade(countries));
        pool1.add(new BuyVaccineUpgrade(countries));
        pool1.add(new BuyVaccineUpgrade(countries));

        List<Upgrade> pool2 = new ArrayList<Upgrade>();
        pool2.add(new MasksUpgrade());
        pool2.add(new MasksUpgrade());
        pool2.add(new MasksUpgrade());
        pool2.add(new MasksUpgrade());
        pool2.add(new MasksUpgrade());
        pool2.add(new QuarantineUpgrade());
        pool2.add(new QuarantineUpgrade());
        pool2.add(new QuarantineUpgrade());
        pool2.add(new QuarantineUpgrade());
        pool2.add(new QuarantineUpgrade());

        List<Upgrade> pool3 = new ArrayList<Upgrade>();
        pool3.add(new FinanceUpgrade());
        pool3.add(new FinanceUpgrade());
        pool3.add(new FinanceUpgrade());
        pool3.add(new FinanceUpgrade());
        pool3.add(new FinanceUpgrade());
        pool3.add(new TaxesUpgrade());
        pool3.add(new TaxesUpgrade());
        pool3.add(new TaxesUpgrade());
        pool3.add(new TaxesUpgrade());
        pool3.add(new TaxesUpgrade());

        List<Upgrade> pool4 = new ArrayList<Upgrade>();
        pool4.add(new ElderUpgrade());
        pool4.add(new ElderUpgrade());
        pool4.add(new ElderUpgrade());
        pool4.add(new CleaningUpgrade());
        pool4.add(new CleaningUpgrade());
        pool4.add(new CleaningUpgrade());
        pool4.add(new TestsUpgrade());
        pool4.add(new TestsUpgrade());
        pool4.add(new TestsUpgrade());
        pool4.add(new TestsUpgrade());

        for (Country country: countries.values()) {
            country.mortalityLvl *= difficultyLvl.mortalityLvl;
            Random generator = new Random();

            Upgrade drawn =  pool1.get(generator.nextInt(pool1.size()));
            country.upgrades.add(drawn);
            pool1.remove(drawn);

            Upgrade drawn1 =  pool2.get(generator.nextInt(pool2.size()));
            country.upgrades.add(drawn1);
            pool2.remove(drawn1);

            Upgrade drawn2 =  pool3.get(generator.nextInt(pool3.size()));
            country.upgrades.add(drawn2);
            pool3.remove(drawn2);

            Upgrade drawn3 =  pool4.get(generator.nextInt(pool4.size()));
            country.upgrades.add(drawn3);
            pool4.remove(drawn3);
        }
        transports = new ArrayList<Transport>();
        transports.add(new Transport(countries.get("Poland"), countries.get("Germany")));
        transports.add(new Transport(countries.get("Spain"), countries.get("France")));
        transports.add(new Transport(countries.get("France"), countries.get("England")));

        transports.add(new Transport(countries.get("England"), countries.get("Spain")));
        transports.add(new Transport(countries.get("Germany"), countries.get("Italy")));
        transports.add(new Transport(countries.get("Sweden"), countries.get("Germany")));
        transports.add(new Transport(countries.get("Ukraine"), countries.get("Sweden")));
        transports.add(new Transport(countries.get("Romania"), countries.get("Ukraine")));
        transports.add(new Transport(countries.get("Italy"), countries.get("Greece")));
        transports.add(new Transport(countries.get("Greece"), countries.get("Romania")));
        transports.add(new Transport(countries.get("Germany"), countries.get("Greece")));
        transports.add(new Transport(countries.get("Poland"), countries.get("Ukraine")));
        transports.add(new Transport(countries.get("France"), countries.get("Germany")));

        startCountry = ChoseStartCountry();
    }

    public Country ChoseStartCountry(){
        Random generator = new Random();
        Object[] values = countries.values().toArray();
        Country randomCountry = (Country) values[generator.nextInt(values.length)];

        return randomCountry;
    }

}
