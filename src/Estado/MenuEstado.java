package Estado;

import Font.FontLoader;
import assemblerinterpretadorfacul.Acessos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JTextField;

public class MenuEstado extends Estado
{

    private int escolha = 0;
     
    private String modos[] = {"Expressão", "Assembly"};
    
   
     
    public MenuEstado(Acessos acessos)
    {
        super(acessos);
    }
    
    
    @Override
    public void atualizar()
    {
        if(acessos.getTeclado().isCima())
        {
            escolha--;
            if(escolha < 0) escolha = 0;
        }
        
        if(acessos.getTeclado().isBaixo())
        {
            escolha++;
            if(escolha > 1) escolha = 1;
        }
        
        
        if(acessos.getTeclado().isEnter())
        {
            switch(escolha)
            {
                case 0:
                    acessos.setEstado(acessos.getExEst());
                    break;
                case 1:
                    acessos.setEstado(acessos.getaEst());
                    break;
            }
        }
    }

    @Override
    public void desenhar(Graphics g) 
    {
        g.setColor(Color.white);
        g.setFont(trucking);
      
        
        g.drawString("Super Assembler", 40, 50);
        g.drawString("Interpreter 9000", 40, 80);
        
        g.setFont(neon);
        
        for (int i = 0; i < modos.length; i++) 
        {
            if(escolha == i)g.setColor(Color.yellow);
            else g.setColor(Color.white);
            
            g.drawString(modos[i], 70, 220 + (i * 60));
        } 
        g.setColor(Color.white);
        g.drawString("Guilherme (21002514)", 10, 400);
        g.drawString("Diony (20781283)", 12, 440);
    }
}
