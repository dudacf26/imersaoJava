package com.lista;

public class Lista {

    public static void main(String[] args) {
        fibonaci(); // aqui estou chamando a função Fibonacci

        //EXERCICIO 1

        for (int i = 150; i <= 300; i++) {
            System.out.println("imprimindo o " + i);
        }

        //Exercicio 2
        int soma = 0;
        for (int i = 0; i <= 1000; i++) {
            soma += i;
        }
        System.out.println(soma);


        //Exercicio 3

        for (int i = 0; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.println("Imprimindo múltiplos de 3: " + i);
            }
        }

        //Exercicio 4
        int result = 1;
        for (int i = 0; i <= 10; i++) {
            result = result * i;
            System.out.println("O fatorial de " + i + " é: " + result);
        }

        //Exercicio 5
        for (int i = 1; i <= 10; i++) {
            System.out.println("Esse é a Potencia de:" + i);
            for (int j = 1; j <= 10; j++) {
                int resultPotencia = i * j;
                System.out.println(resultPotencia);
            }
        }

        //Exercicio 6
        for (int i = 1; i <= 40; i++) {
            System.out.println("Esse é a Potencia de:" + i);
            for (int j = 1; j <= 40; j++) {
                int resultPotenciacao = i * j;
                System.out.println(resultPotenciacao);
            }
        }
    } // fim static void

    //Exercicio 7

    public static void fibonaci() {

        Integer primeiroNumero = 0;
        Integer segundoNumero = 1;
        Integer valorMaximo = 100;
        String fibonaci = "" + primeiroNumero;

        for (int i = 0; i <= valorMaximo; i++) {
            Integer resultadoFibonacci = primeiroNumero + segundoNumero;

            primeiroNumero = segundoNumero;
            segundoNumero = resultadoFibonacci;

            fibonaci += "," + resultadoFibonacci;
            if (resultadoFibonacci > valorMaximo) {
                break;
            }
        }
        System.out.println("Resultado:" + fibonaci);
    }
}




