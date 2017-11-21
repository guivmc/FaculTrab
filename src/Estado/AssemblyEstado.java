package Estado;

import Comandos.Comandos;
import Linha.LinhaDesenho;
import assemblerinterpretadorfacul.Acessos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AssemblyEstado extends Estado implements ActionListener
{  
    private Comandos com;
    
    private ArrayList<LinhaDesenho> linhasDesenho = new ArrayList<>();
    
    private JFrame frame2;
    private JPanel panel;
    private JTextField text;
    private String JText;
    private boolean frameFeito;
    private int posY;
    
    public AssemblyEstado(Acessos acessos) 
    {
        super(acessos);
        
        linhasDesenho = new ArrayList<>();
  
        com = new Comandos();
       
        frameFeito = false;
        posY = 40;
       
    }
    
    public void criarFrame2()
    {
         //Frame2
        frame2 = new JFrame();
        frame2.setVisible(true);
        frame2.setResizable(true);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        
        text = new JTextField(7);
        //text.addActionListener(actionPerformed());
         text.addActionListener(this);
        
        
        panel.add(text);
    
        frame2.add(panel);
        
        frame2.pack();
        
        frameFeito = true;
    }

     @Override
    public void actionPerformed(ActionEvent ae) 
    { 
        
        JText = text.getText();
        posY += 30;       
        linhasDesenho.add(new LinhaDesenho(JText, 10, posY));
       
    }
    
    
    @Override
    public void atualizar() 
    {  
        if(!frameFeito) criarFrame2();
        if(acessos.getTeclado().isEnter())
        {
            //linhasDesenho.add(new LinhaDesenho(JText, 10, posY));
            com.executarComando(JText);
        }
    }

    @Override
    public void desenhar(Graphics g) 
    {
         g.setColor(Color.white);
         g.setFont(neon);
//         System.out.println(linhasDesenho.size());
         for(int i = 0; i < linhasDesenho.size(); i++)
         {
            LinhaDesenho ld = linhasDesenho.get(i);
            g.drawString(ld.getTexto(), ld.getX(), ld.getY());
         }
         com.desenhar(g);
//         linhasDesenho.forEach((l) -> 
//         {
//             g.drawString(l.getTexto(), l.getX(), l.getY());
//         });
    }
  
}
