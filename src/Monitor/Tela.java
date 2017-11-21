package Monitor;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela 
{
    private JFrame frame, frame2;
    private JPanel panel;
    private JTextField text;
    private Canvas canvas;
    
    private int largura, altura, posY = 0;
    
    private String jText = "";
     
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
        frame.setResizable(true);
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
    
    public String getJText()
    {
        return jText;
    }
    
    public int getPosY()
    {
        return posY;
    }
}
