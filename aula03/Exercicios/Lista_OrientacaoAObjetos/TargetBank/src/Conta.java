import java.time.LocalDate;

public class Conta {

    private String nomeTitular;
    private int numero;
    private String agencia;
    private double saldo;
    private LocalDate dataDeAbertura;

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(LocalDate dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public Double sacarDinheiro(double valor) {
        if (saldo >= valor) {
            saldo = saldo - valor;
            System.out.println("Você sacou R$: " + valor + " e seu saldo ficou R$: " + saldo);
        } else {
            System.out.println("Saldo Insuficiente para sacar o valor R$" + valor);
        }
        return saldo;
    }

    public Double depositarDinheiro(double valor){
            saldo = saldo + valor;
            System.out.println("Você depositou R$: " + valor + " e seu saldo ficou R$: " + saldo);
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "nomeTitular='" + nomeTitular + '\'' +
                ", numero=" + numero +
                ", agencia='" + agencia + '\'' +
                ", saldo=" + saldo +
                ", dataDeAbertura=" + dataDeAbertura +
                '}';
    }
}
