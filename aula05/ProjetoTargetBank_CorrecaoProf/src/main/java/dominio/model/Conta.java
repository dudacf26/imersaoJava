package dominio.model;

import java.util.List;

public class Conta {
    private long numero;
    private int agencia;
    private List<Movimento> movimentos;

    public Conta(long numeroContaCorrentista, int agenciaCorrentista) {
        this.numero = numeroContaCorrentista;
        this.agencia = agenciaCorrentista;
    }

    public long getNumero() {
        return this.numero;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public List<Movimento> getMovimentos() {
        return this.movimentos;
    }

    public void setMovimentos(List<Movimento> movimentos) {
        this.movimentos = movimentos;
    }
}
