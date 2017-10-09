
package assemblerinterpretadorfacul;

import Monitor.Tela;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class Controle implements Runnable
{
    private boolean executando = false;
    
    private Thread thread;
    private Tela tela;
    private Graphics grafico;
    
    public Controle(String titulo, int l , int a)
    {
        tela = new Tela(titulo, l, a);
    }
    
    
    public void desenhar()
    {
        grafico.clearRect(0, 0, tela.getLargura(), tela.getAltura());
        
        

        grafico.dispose();
    }
    
    public void atualizar()
    {
        
    }
    
     public synchronized void start()
    {
        if(executando)
        {
            return;
        }
        executando = true;
        thread = new Thread(this);
        //call run();
        thread.start();
    }
    
    //Stop that thread
    public synchronized void stop()
    {
        if(!executando)
        {
            return;
        }
        
        executando = false;
        
        try 
        {
            thread.join();
        } 
        catch (InterruptedException ex) 
        {
            //Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public void run() 
    {       
       while(executando)
       {
           atualizar();
           desenhar();
       }
       
       stop();
    }   
}
