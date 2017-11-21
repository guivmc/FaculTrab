package Estado;

import Font.FontLoader;
import assemblerinterpretadorfacul.Acessos;
import java.awt.Font;
import java.awt.Graphics;


public abstract class Estado 
{
    //Game State Manager
    private static Estado atualEstado = null;
   
   
    public static void setEstado(Estado s)
    {
        atualEstado = s;
    }
    
    public static Estado getEstado()
    {
        return atualEstado;
    }
    
    
    
    
    protected Acessos acessos;
    
    protected Font neon, trucking; 
    
    public Estado(Acessos acessos)
    {
        this.acessos = acessos;
        
        neon = FontLoader.loadFont("src/Fonts/Neon.ttf",30);
        trucking = FontLoader.loadFont("src/Fonts/KeeponTruckin.ttf", 30);        
    }
    
    public abstract void atualizar();
    
    public abstract void desenhar(Graphics g);
    
}
