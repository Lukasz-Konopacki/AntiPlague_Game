import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Config();

        SwingUtilities.invokeLater(() -> Window.Create());
    }

    public static void Config(){
        // Dodanie nowych czcionek
        //https://docs.oracle.com/javase/tutorial/2d/text/fonts.html
        try {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Virus_53X.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Tretton.ttf")));
        } catch (IOException |FontFormatException e) {
            //Handle exception
        }
        //Ustawienie domyslnej czcionki
        //https://www.rgagnon.com/javadetails/java-0335.html
        Font f = new Font("Tretton", 0, 24);
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put (key, f);
        }
    }
}
