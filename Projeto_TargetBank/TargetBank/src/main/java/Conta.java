import java.util.List;

public class Conta {

    private Integer agencia;
    private Integer numero;
    private Double saldo;

    public Conta(int numeroContaCorrentista, int agenciaCorrentista) {
        this.numero = numeroContaCorrentista;
        this.agencia = agenciaCorrentista;
    }

    // Movimentos <List> movimentos;


    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
/*
    public boolean validaLogin(Integer lendoAgencia, Integer lendoNumero, Integer lendoSenha) {
        if (lendoAgencia == getAgencia() && lendoNumero == getNumero() && lendoSenha == getSenha()) {
            return true;
        }
        return false;
    }*/

}
