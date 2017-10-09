package Monitor;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Tela 
{
    private JFrame frame;
    private Canvas canvas;
    
    private int largura, altura;
     
    public Tela(String titulo, int l, int a)
    {
        this.largura = l;
        this.altura = a;
        
        criarTela(titulo);
    }

    private void criarTela(String titulo) 
    {     
        //create and set JFrame
        frame = new JFrame(titulo);
        frame.setSize(largura, altura);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
        // create and set canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(largura, altura));
        canvas.setMaximumSize(new Dimension(largura, altura));
        canvas.setMinimumSize(new Dimension(largura, altura));
        canvas.setFocusable(false);
        canvas.setBackground(Color.black);
       
        //add canvas to the JFrame
        frame.add(canvas);
    }
    
    
    
    //gets
    public Canvas getCanvas()
    {
        return canvas;
    }
    
    public JFrame getFrame()
    {
        return frame;
    }
    
    public int getLargura()
    {
        return largura;
    }
    
    public int getAltura()
    {
        return altura;    
    }
}
