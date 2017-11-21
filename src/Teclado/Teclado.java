package Teclado;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener
{
    
    private boolean enter, cima, baixo;

    @Override
    public void keyTyped(KeyEvent ke)
    {
       
    }

    @Override
    public void keyPressed(KeyEvent ke) 
    {
        int tecla = ke.getKeyCode();
        
        if(tecla == KeyEvent.VK_ENTER) enter = true;
        if(tecla == KeyEvent.VK_UP) cima = true;
        if(tecla == KeyEvent.VK_DOWN) baixo = true;
        
    }
    @Override
    public void keyReleased(KeyEvent ke) 
    {
        int tecla = ke.getKeyCode();
        
        if(tecla == KeyEvent.VK_ENTER) enter = false;
        if(tecla == KeyEvent.VK_UP) cima = false;
        if(tecla == KeyEvent.VK_DOWN) baixo = false;
    }
   
    //Getters
    public boolean isEnter() 
    {
        return enter;
    }

    public boolean isCima() 
    {
        return cima;
    }

    public boolean isBaixo() 
    {
        return baixo;
    }
    
    //Setters
    public void setEnter(boolean enter) 
    {
        this.enter = enter;
    }

    public void setCima(boolean cima) 
    {
        this.cima = cima;
    }

    public void setBaixo(boolean baixo) 
    {
        this.baixo = baixo;
    }
    
    
    
}
