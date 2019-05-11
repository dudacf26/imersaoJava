package com.calc;

public class Calculadora {
    private Pessoa pessoa;

    public Calculadora(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    /*modificador de acesso / retorno / nome da função
    assinatura do método -> Double calcularIMC (Param a, Param b)
     */
    public Double calcularIMC() {
        Double imc = this.pessoa.getPeso() / (this.pessoa.getAltura()
                       * this.pessoa.getAltura());
        Double imcFormatado = imc * 10000;
        return imcFormatado;
    }
}
