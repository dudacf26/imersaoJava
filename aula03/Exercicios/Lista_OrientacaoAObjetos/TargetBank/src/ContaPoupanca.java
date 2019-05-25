import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class ContaPoupanca extends Conta {

    private LocalDate dataAniversario;

    public double calcularRendimento() {
        double rendimento = 0;
        dataAniversario = this.dataAniversario !=null ? dataAniversario : LocalDate.now();
        LocalDate hoje = LocalDate.now();
        boolean passou30Dias = DAYS.between(super.getDataDeAbertura(), dataAniversario) >= 30;
        if (!passou30Dias) {
            rendimento = getRendimento();
            System.out.println("Seu saldo fico R$ " + super.getSaldo());
        }else{
            rendimento = getSaldo();
        }
        return rendimento;
    }

    private double getRendimento() {
        double rendimento;
        rendimento = getSaldo() * 0.10;
        super.setSaldo(rendimento+getSaldo());
        this.dataAniversario = LocalDate.now();
        return rendimento;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "dataAniversario=" + dataAniversario +
                '}';
    }
}
