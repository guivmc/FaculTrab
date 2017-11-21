package Expressão;

import Linha.LinhaDesenho;
import java.awt.Graphics;
import java.util.ArrayList;


public class Expressao 
{
    private ArrayList<LinhaDesenho> linhasDesenho = new ArrayList<>();
    
    private char var = '@';
    
    private StringBuilder expressao;
    
    private String stringAnterior = new String();
    
    private int posY = 40;
    
    public void ler(String s)
    {
        if(s == null) return;
        if(stringAnterior.equals(s)) return;
        
        stringAnterior = s;
        
        expressao = new StringBuilder(s);
        
        separar(expressao.toString());        
    }
    
    public void separar(String s)
    {
        
        StringBuilder sbs = new StringBuilder(s);
       
        boolean open = false;
        
        int pos9 = 0, pos0 = 0; 
         
        for (int i = 0; i < sbs.length(); i++) 
        {
           
           // checa os () mais internos possíveis 
            if(sbs.charAt(i) == '(' && sbs.charAt(i + 1) != '(')
            {
                pos9 = i + 1;
                open = true;
            }
            if(open)
            {
                if(sbs.charAt(i) == '(') pos9 = i + 1;
                if(sbs.charAt(i) == ')')
                {
                    pos0 = i;
                    open = false;
                    calcular(sbs.substring(pos9, pos0), pos9, pos0);
                    break;
                }    
            }   
        }
        
    }
    
    public void calcular(String s, int pos9, int pos0)
    {
        StringBuilder sbc = new StringBuilder(s);        
        for (int i = 0; i < sbc.length(); i++) 
        {
              if(sbc.charAt(i) == '/')
              {
                  var += 1;
                  printMOV(var, sbc.charAt(i - 1));
                  printDIV(var, sbc.charAt(i + 1));
                  sbc.replace((i - 1), (i + 2) , var + "");
              }
        }
        for (int i = 0; i < sbc.length(); i++) 
        {
              if(sbc.charAt(i) == '*')
              {
                  var += 1;
                  printMOV(var, sbc.charAt(i - 1));
                  printMPY(var, sbc.charAt(i + 1));
                  sbc.replace((i - 1), (i + 2) , var + "");
              }
        }
        for (int i = 0; i < sbc.length(); i++) 
        {
             if(sbc.charAt(i) == '+')
             {
                 var += 1;
                 printMOV(var, sbc.charAt(i - 1));
                 printADD(var, sbc.charAt(i + 1));
                 sbc.replace((i - 1), (i + 2) , var + "");
             }
        }
        for (int i = 0; i < sbc.length(); i++)
        {
             if(sbc.charAt(i) == '-')
             {
                 var += 1;
                 printMOV(var, sbc.charAt(i - 1));
                 printSUB(var, sbc.charAt(i + 1));
                 sbc.replace((i - 1), (i + 2) , var + "");
             }
        }

        if(sbc.length() == 1)
        {
            //fim da conta, checa se há mais alguma
            expressao.replace((pos9 - 1), (pos0 + 1), var + "");
            if(expressao.length() > 1)separar(expressao.toString());
        }
        else if(sbc.length() > 1)
        {
            //O replace pode apagar os () iniciais e deixar uma conta sem resolver 
            sbc.insert(0, '(');
            sbc.insert(sbc.length(), ')');
            separar(sbc.toString());
        }
    }
    
    private void printMOV(char var, char constVar)
    {
        linhasDesenho.add(new LinhaDesenho("MOV " + var + ", " + constVar, 10, posY));
        posY += 30;
    }
    
    private void printADD(char var, char constVar)
    {
        linhasDesenho.add(new LinhaDesenho("ADD " + var + ", " + constVar, 10, posY));
        posY += 30;
    }
    
    private void printSUB(char var, char constVar)
    {
        linhasDesenho.add(new LinhaDesenho("SUB " + var + ", " + constVar, 10, posY));
        posY += 30;
    }
    
    private void printDIV(char var, char constVar)
    {
        linhasDesenho.add(new LinhaDesenho("DIV " + var + ", " + constVar, 10, posY));
        posY += 30;
    }
    
    private void printMPY(char var, char constVar)
    {
        linhasDesenho.add(new LinhaDesenho("MPY " + var + ", " + constVar, 10, posY));
        posY += 30;   
    }
    
    public void desenhar(Graphics g)
    {
        for(LinhaDesenho ld : linhasDesenho)
        {
            g.drawString(ld.getTexto(), ld.getX(), ld.getY());
        }
    }
}
