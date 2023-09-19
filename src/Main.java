import MenuComponents.MenuWindow;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Config();
        SwingUtilities.invokeLater(() -> MenuWindow.Create());
    }

    public static void Config(){
        //Rozwiazuje problem z wyglada JIternalFrame
        //https://stackoverflow.com/questions/25898811/change-java-jinternalframe-title-bar-theme
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            System.out.println("failed to load Swing Look & Feel");
        }


        // Dodanie nowych czcionek
        //https://docs.oracle.com/javase/tutorial/2d/text/fonts.html
        try {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Virus_53X.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/VT323-Regular.ttf")));
        } catch (IOException |FontFormatException e) {
            //Handle exception
        }
        //Ustawienie domyslnej czcionki
        //https://www.rgagnon.com/javadetails/java-0335.html
        Font f = new Font("VT323", Font.PLAIN, 24);
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put (key, f);
        }
    }
}
