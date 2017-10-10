/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpretadorassembly;

import java.util.Scanner;

public class Assembly {

    private String texto, codigo = "";
    private String auxiliar[] = new String[3];

    public String getTexto() {
        return texto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void cod() {

        char operando = operacao();

        switch (operando) {
            case '=':

                auxiliar[valorAuxiliar()] = quebrar(1);

                break;
            case '-':
                if (valorAuxiliar2() < 3) {
                    auxiliar[valorAuxiliar()] = auxiliar[valorAuxiliar()] + " - " + "( " + auxiliar[valorAuxiliar2()] + " )";
                } else {
                    auxiliar[valorAuxiliar()] = auxiliar[valorAuxiliar()] + " - " + quebrar(1);
                }
                break;
            case '+':
                if (valorAuxiliar2() < 3) {
                    auxiliar[valorAuxiliar()] = auxiliar[valorAuxiliar()] + " + " + "( " + auxiliar[valorAuxiliar2()] + " )";
                } else {
                    auxiliar[valorAuxiliar()] = auxiliar[valorAuxiliar()] + " + " + quebrar(1);
                }
                break;
            case '*':
                if (valorAuxiliar2() < 3) {
                    auxiliar[valorAuxiliar()] = auxiliar[valorAuxiliar()] + " * " + "( " + auxiliar[valorAuxiliar2()] + " )";
                } else {
                    auxiliar[valorAuxiliar()] = "( " + auxiliar[valorAuxiliar()] + " )" + " * " + quebrar(1);
                }
                break;
            case '/':
                if (valorAuxiliar2() < 3) {
                    auxiliar[valorAuxiliar()] = auxiliar[valorAuxiliar()] + " / " + "( " + auxiliar[valorAuxiliar2()] + " )";
                } else {
                    auxiliar[valorAuxiliar()] = "( " + auxiliar[valorAuxiliar()] + " )" + " / " + quebrar(1);
                }
                break;
        }

        codigo = auxiliar[valorAuxiliar()];

    }

    public int valorAuxiliar() {
        if (quebrar(0).equalsIgnoreCase("x")) {
            return 0;
        }
        if (quebrar(0).equalsIgnoreCase("y")) {
            return 1;
        } else {
            return 2;
        }
    }

    public char operacao() {
        char operando = 0;
        if (texto.startsWith("mov", 0)) {
            operando = '=';
        }
        if (texto.startsWith("add", 0)) {
            operando = '+';
        }
        if (texto.startsWith("sub", 0)) {
            operando = '-';
        }
        if (texto.startsWith("div", 0)) {
            operando = '/';
        }
        if (texto.startsWith("mpy", 0)) {
            operando = '*';
        }
        return operando;
    }

    public void inserirAss() {
        Scanner s = new Scanner(System.in);
        System.out.println("Insira a Linha de codigo");
        texto = s.nextLine();
        if (texto.equalsIgnoreCase("fim")) {
            System.out.println("x = " + getCodigo());
        } else {
            cod();
        }
    }

    public String quebrar(int local) {

        String token[] = texto.split(" ");
        String tokens[] = token[1].split(",");
        String variavel = tokens[local];
        return variavel;
    }

    public int valorAuxiliar2() {
        if (quebrar(1).equalsIgnoreCase("x")) {
            return 0;
        }
        if (quebrar(1).equalsIgnoreCase("y")) {
            return 1;
        }
        if (quebrar(1).equalsIgnoreCase("z")) {
            return 2;
        } else {
            return 3;
        }
    }

}
