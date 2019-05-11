package com.calc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main (String[] args){

        imprimePares();// aqui estou chamando a função ImprimePares
        Scanner teclado = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("Calculadora de IMC");
        System.out.println("===================================");

            boolean sair = false;
            int opcao = 0;
            do{
                System.out.println("\n1 - Calcular IMC");
                System.out.println("0 - Sair");

                opcao = teclado.nextInt();

                sair = opcao == 0 ? true : false;

                if(opcao == 1){
                    System.out.println("Insira o peso da pessoa:");
                    Double peso = teclado.nextDouble();

                    System.out.println("Insira a altura da pessoa:");
                    int altura = teclado.nextInt();

                    Pessoa pessoa = new Pessoa(peso,altura);
                    Calculadora calculadora = new Calculadora(pessoa);

                    Double imc = calculadora.calcularIMC();

                    System.out.printf("O IMC calculado é %.2f " + imc);
                }

            }while (!sair);
        }

        public static void imprimePares(){
            int [] numeros = {10, 20, 30, 40};
            //quantas posições? 4
            // tamanho ?? 4
            // index 0 ... 3
            // Como eu sei que um numero é inteiro?
        for (int i = 0; i < numeros.length;i++){
            int numero = 0;
            if(numeros[i] % 2 == 0){
                numero = numeros[i];
                System.out.println(numero);

            }
        }
    }

    public void arrayTest(){
        ArrayList<Pessoa> pessoasLista = new ArrayList<>();

        Pessoa p1 = new Pessoa((double)85,170);
        pessoasLista.add(p1);

        /*for(int i = 0; i < pessoasLista.size(); i++){
            System.out.println("Altura: " + pessoasLista.get(i).getAltura());
            System.out.println("Peso:" + pessoasLista.get(i).getPeso());

        }*/

        //foreach
        for (Pessoa pessoa : pessoasLista) {
            System.out.println("Altura: " + pessoa.getAltura());
            System.out.println("Peso:" + pessoa.getPeso());
        }

        pessoasLista.forEach(pessoa -> {
            System.out.println("Altura: " + pessoa.getAltura());
            System.out.println("Peso:" + pessoa.getPeso());
        });

        pessoasLista.stream() //java 8
                .filter(pessoa -> pessoa.getPeso() > 30)
                .collect(Collectors.toList());

    }
}




