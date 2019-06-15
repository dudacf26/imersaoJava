package dominio.model;

public class Correntista {

    private Conta conta;
    private int senha;
    private String nome;

    public Correntista(Conta conta, int senha, String nome) {
        this.conta = conta;
        this.senha = senha;
        this.nome = nome;
    }

    public Conta getConta() {
        return this.conta;
    }

    public int getSenha() {
        return this.senha;
    }

    public String getNome() {
        return this.nome;
    }
}
