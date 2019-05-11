package com.company;

public class Main {

    public static void main(String[] args) {
        Nota nota1 = new Nota();
        nota1.setValor(10.0);
        Nota nota2 = new Nota();
        nota2.setValor(6.5);

        Double media = calcularMediaDasNotas(nota1,nota2);

    }

    public static Double calcularMediaDasNotas(Nota nota1, Nota nota2){

       Double resultado = (nota1.getValor() + nota2.getValor()) / 2;
        return resultado;
    }
}


