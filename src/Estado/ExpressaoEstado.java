package Estado;

import Expressão.Expressao;
import assemblerinterpretadorfacul.Acessos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ExpressaoEstado extends Estado implements ActionListener
{
    private JFrame frame2;
    private JPanel panel;
    private JTextField text;
    private String JText;
    private boolean frameFeito;
    
    private Expressao exp;

    public ExpressaoEstado(Acessos acessos) 
    {
        super(acessos);
        
        exp = new Expressao();
        
        frameFeito = false;
    }

    @Override
    public void atualizar() 
    {
         if(!frameFeito) criarFrame2();
         
        if(acessos.getTeclado().isEnter())
        {    
           exp.ler(JText);
        }
    }

    @Override
    public void desenhar(Graphics g) 
    {
         g.setColor(Color.white);
         g.setFont(neon);
         
         exp.desenhar(g);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        JText = text.getText();
    }

    private void criarFrame2()
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
    
}
