
package Linha;

public class Linha 
{
    String texto;
    
    
    public Linha(String texto) 
    {
        this.texto = texto;
    }

    //Getters
    public String getTexto() 
    {
        return texto;
    }
    
    public String getEspressao()
    {
        return texto.substring(3, texto.length());
    }

    //Setters
    public void setTexto(String texto) 
    {
        this.texto = texto;
    }
}
