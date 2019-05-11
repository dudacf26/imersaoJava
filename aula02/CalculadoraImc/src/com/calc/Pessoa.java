package com.calc;

public class Pessoa {

    private Double pesoEmKg;
    private int alturaEmCm;

    public Pessoa(Double pesoEmKg, int alturaEmCm){
        this.pesoEmKg = pesoEmKg;
        this.alturaEmCm = alturaEmCm;
    }

    public Double getPeso() {
        return pesoEmKg;
    }

    public int getAltura() {
        return alturaEmCm;
    }
}
