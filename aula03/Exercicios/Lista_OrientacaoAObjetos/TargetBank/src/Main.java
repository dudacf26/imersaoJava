import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Conta c1 = new Conta();
        ContaPoupanca cp = new ContaPoupanca();

        c1.setNumero(231);
        c1.setNomeTitular("Logan");
        c1.setAgencia("centro");
        c1.setSaldo(1000);
        c1.setDataDeAbertura(LocalDate.of(2019,4,6));
        c1.sacarDinheiro(200);
        c1.depositarDinheiro(1000);
        System.out.println(c1.toString());

/*
        cp.setNumero(123);
        cp.setNomeTitular("Eduarda");
        cp.setAgencia("cristovao colombo");
        cp.setSaldo(500);
        cp.setDataDeAbertura(LocalDate.of(2019,4,6));
        cp.sacarDinheiro(200);
        cp.depositarDinheiro(1000);
        c1.toString();
        System.out.println("O rendimento é "+ cp.calcularRendimento());
*/

    }
}
