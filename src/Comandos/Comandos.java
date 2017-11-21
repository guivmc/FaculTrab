package Comandos;

import Linha.Linha;
import Linha.LinhaDesenho;
import java.awt.Graphics;
import java.util.ArrayList;

public class Comandos 
{
    private enum commands{MOV, MPY, SUB, ADD, DIV};
    
    private commands instrucao;
    
    private String stringAnterior = new String();
    
     private int posY = 70;
    
    private ArrayList<LinhaDesenho> linhasDesenho = new ArrayList<>();
    
    private ArrayList<Linha> linhas = new ArrayList<>();
    
    public Comandos(){}
    
    public void executarComando(String s)
    {      
        if(s == null) return;
        if(stringAnterior.equals(s)) return;
        
        stringAnterior = s;
 
        String[] vetorDaInstrucao = s.split(" ");
        
        if(vetorDaInstrucao.length <= 1 || vetorDaInstrucao.length < 3 || vetorDaInstrucao.length > 3) return;
        
        char var = vetorDaInstrucao[1].charAt(0);
        char var2 = vetorDaInstrucao[2].charAt(0);
  
        try
        {
            instrucao = commands.valueOf(vetorDaInstrucao[0].toUpperCase());
        }
        catch(IllegalArgumentException exc)
        {
            return;
        }
        
        
        Linha l, l2;
        
        switch(instrucao)
        {
            case MOV:
                //não se pode ter duas variáveis com o mesmo inicial
                pesquisarEliminarLinha(var);
                l2 = pesquisarLinha(var2);
                              //cria uma nova linha
                if(l2 != null)linhas.add(new Linha(var + "= " + l2.getEspressao()));
                else linhas.add(new Linha(var + "= " + var2));
                linhasDesenho.add(new LinhaDesenho(var + "= " + var2, 150, posY));
                break;
            case MPY:
                l = pesquisarLinha(var);
                l2 = pesquisarLinha(var2);
                if(l != null && l2 !=null)l.setTexto(l.getTexto().concat(" * " + l2.getEspressao()));
                else if(l != null) l.setTexto(l.getTexto().concat(" * " + var2));
                linhasDesenho.add(new LinhaDesenho(l.getTexto(), 150, posY));
                break;
            case SUB:
                l = pesquisarLinha(var);
                l2 = pesquisarLinha(var2);
                if(l != null && l2 !=null)l.setTexto(l.getTexto().concat(" - " + l2.getEspressao()));
                else if(l != null)l.setTexto(l.getTexto().concat(" - " + var2));
                linhasDesenho.add(new LinhaDesenho(l.getTexto(), 150, posY));
                break;
            case ADD:
                l = pesquisarLinha(var);
                l2 = pesquisarLinha(var2);
                if(l != null && l2 !=null)l.setTexto(l.getTexto().concat(" + " + l2.getEspressao()));
                else if(l != null)l.setTexto(l.getTexto().concat(" + " + var2));
                linhasDesenho.add(new LinhaDesenho(l.getTexto(), 150, posY));
                break;
            case DIV:
                 l = pesquisarLinha(var);
                 l2 = pesquisarLinha(var2);
                 if(l != null && l2 !=null)l.setTexto(l.getTexto().concat(" / " + l2.getEspressao()));
                 else if(l != null)l.setTexto(l.getTexto().concat(" / " + var2));
                 linhasDesenho.add(new LinhaDesenho(l.getTexto(), 150, posY));
                break;
            default:
                return;
        }
        posY += 30;
        instrucao = null;
    }
    
    //limpa toda a linha para 
    public void pesquisarEliminarLinha(char var)
    {
        if(linhas.isEmpty()) return;
        for(int i = 0; i < linhas.size(); i++)
        {
            Linha l = linhas.get(i);
            if(l.getTexto().charAt(0) == var)
            {
                linhas.remove(l);
            }
        }
    }
    
    //procura por variável para achar o resto da expressão
    public Linha pesquisarLinha(char var)
    {
        for(Linha l: linhas)
        {
            if(l.getTexto().charAt(0) == var)
            {
                return l;
            }
        }
        
        return null;
    }
    //procura pela 2ª variável para achar o resto da expressão
    public Linha pesquisarVar2(char var2)
    {
         for(Linha l: linhas)
        {
            if(l.getTexto().charAt(0) == var2)
            {
                return l;
            }
        }
         
        return null;
    }
    
    public void desenhar(Graphics g)
    {
        for(LinhaDesenho ld : linhasDesenho)
        {
            g.drawString(ld.getTexto(), ld.getX(), ld.getY());
        }
    }
}
