
package assemblerinterpretadorfacul;

import Comandos.Comandos;
import Estado.Estado;
import Estado.MenuEstado;
import Monitor.Tela;
import Teclado.Teclado;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;



public class Controle implements Runnable
{
    private boolean executando = false;
    
    private Thread thread;
    private Tela tela;
    private Graphics grafico;
    private BufferStrategy bs;
    

    //ter acesso  ao teclado sem criar um novo controle
    private Acessos acessos;
    
    private Teclado teclado;
    
    
    public Controle(String titulo, int l , int a)
    {
        tela = new Tela(titulo, l, a);
        
        tela.getCanvas().createBufferStrategy(3);
        
        teclado = new Teclado();
        
        acessos = new Acessos(this);
        
        tela.getFrame().addKeyListener(teclado);
            
    }
    
    
    public void desenhar()
    {
        bs = tela.getCanvas().getBufferStrategy();
        
        grafico = bs.getDrawGraphics();
        
        grafico.clearRect(0, 0, tela.getLargura(), tela.getAltura());
        
        Estado.getEstado().desenhar(grafico);

        bs.show();
        grafico.dispose();
    }
    
    public void atualizar()
    {
      Estado.getEstado().atualizar();
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

  
    @Override
    public void run() 
    {       
       acessos.setEstado(acessos.getmEst());
       while(executando)
       {
           atualizar();
           desenhar();
       }
       
       stop();
    }  
    
    //Getters
    public Teclado getTeclado()
    {
        return teclado;
    }
    
    public Tela getTela()
    {
        return tela;
    } 
}
