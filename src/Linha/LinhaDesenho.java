package Linha;


public class LinhaDesenho 
{
    private int x, y;

    private String texto;
    
    public LinhaDesenho(String s, int x, int y)
    {
        this.texto = s;
        this.x = x;
        this.y = y;
    }
    

    public void concatenar(String s)
    {
        texto.concat(s);
    }

    //Getters
    
    public int getX() 
    {
        return x;
    }

    public int getY() 
    {
        return y;
    }

    public String getTexto() 
    {
        return texto;
    }
    
    //Setters
    
    public void setX(int x) 
    {
        this.x = x;
    }

    public void setY(int y) 
    {
        this.y = y;
    }

    public void setTexto(String texto) 
    {
        this.texto = texto;
    }
}
