
package interpretadorassembly;


public class InterpretadorAssembly {

    
    public static void main(String[] args) {
    
        Assembly teste = new Assembly();

        char resposta = 1;
        System.out.println("Para encerrar, digite fim");
        do {
            teste.inserirAss();
            if (teste.getTexto().contains("fim")) {
                resposta = 0;
            } else {
                System.out.println(teste.getCodigo());
            }
        } while (resposta == 1);

    }

}
