public class Correntista {


    private Conta conta;
    private int senha;

    public Correntista(Conta conta,int senhaCorrentista) {
        this.conta = conta;
        this.senha = senhaCorrentista;
    }

    public Conta getConta() {
        return this.conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public int getSenha() {
        return this.senha;
    }
}
