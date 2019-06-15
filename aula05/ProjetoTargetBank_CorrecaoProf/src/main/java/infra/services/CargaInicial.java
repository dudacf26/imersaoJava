package infra.services;

import dominio.model.Conta;
import dominio.model.Correntista;
import dominio.model.Movimento;
import infra.repositories.BancoDeDados;

import java.util.List;

import static java.util.Arrays.asList;

public class CargaInicial {
    public static void populaCorrentistas() {

        List<Movimento> movimentos = asList(
                new Movimento("Paqueta", "D", 50.00D),
                new Movimento("Deposito", "C", 25.00D),
                new Movimento("Saque", "D", 120.00D)
        );

        Conta conta = new Conta(123456,456);
        conta.setMovimentos(movimentos);

        int senha = 987654;
        Correntista correntista = new Correntista(conta, senha, "Zezinho");
        BancoDeDados.getCorrentistas().add(correntista);
    }
}
