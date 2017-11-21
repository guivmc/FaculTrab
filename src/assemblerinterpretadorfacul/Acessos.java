
package assemblerinterpretadorfacul;

import Estado.AssemblyEstado;
import Estado.Estado;
import Estado.ExpressaoEstado;
import Estado.MenuEstado;
import Monitor.Tela;
import Teclado.Teclado;


public class Acessos
{
    private Controle controle;
    
    private Estado mEst, aEst, exEst;

    public Acessos(Controle controle) 
    {
        this.controle = controle;
        
        mEst = new MenuEstado(this);
        
        aEst = new AssemblyEstado(this);
        
        exEst = new ExpressaoEstado(this);
    }
    
    
    public void setEstado(Estado est)
    {
        Estado.setEstado(est);
    }

    public Teclado getTeclado()
    {
        return controle.getTeclado();
    }   

    public Estado getmEst() 
    {
        return mEst;
    }
    
    public Estado getaEst()
    {
        return aEst;
    }

    public Estado getExEst() 
    {
        return exEst;
    }
      
    
    public Tela getTela()
    {
        return controle.getTela();
    }
    
}
