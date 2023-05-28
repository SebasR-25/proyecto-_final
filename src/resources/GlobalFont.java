package resources;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class GlobalFont {

    public static Font customFont = loadFont();

    public static Font loadFont() {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, GlobalFont.class.getResourceAsStream("media/minecraft_font2.3.5.ttf"));
            font = font.deriveFont(Font.BOLD, 40);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

            return font;
        } catch (Exception e) {
            e.printStackTrace();
            return new Font("SansSerif", Font.BOLD, 24);
        }
    }
}
