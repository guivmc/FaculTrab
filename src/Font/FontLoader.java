package Font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;


public class FontLoader 
{
    public static Font loadFont(String arquivo, float tamanho) 
    {
        try
        {
            return Font.createFont(Font.TRUETYPE_FONT, new File(arquivo)).deriveFont(Font.PLAIN, tamanho);
        }
        catch(FontFormatException | IOException e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
}
