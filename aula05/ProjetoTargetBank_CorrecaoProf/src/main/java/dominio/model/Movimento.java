package dominio.model;

public class Movimento {
    private String descricao;
    private String tipo;
    private Double valor;

    public Movimento(String descricao, String tipo, double valor) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getDecricao() {
        return this.descricao;
    }

    public String getTipo() {
        return this.tipo;
    }

    public Double getValor() {
        return this.valor;
    }

    public String getSinal(){
        if (tipo == "C") {
            return "+";
        } else/*D*/ {
            return "-";
        }
    }
}
