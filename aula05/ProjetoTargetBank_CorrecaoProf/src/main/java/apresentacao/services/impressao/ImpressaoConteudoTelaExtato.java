package apresentacao.services.impressao;

import dominio.model.Movimento;

import java.util.List;

public class ImpressaoConteudoTelaExtato implements ImpressaoConteudoInterface {

    private final List<Movimento> movimentos;

    public ImpressaoConteudoTelaExtato(List<Movimento> movimentos) {
        this.movimentos = movimentos;
    }

    @Override
    public String imprimir() {
        return "Extrato\n" +
                "\n" +
                imprimeMovimentos(this.movimentos);
    }

    private String imprimeMovimentos(List<Movimento> movimentos) {
//        return  "Paqueta = -50.00\n" +
//                "Deposito = +25.00\n" +
//                "Saque = -120.00\n";
//
        String listaDeMovimentos = "";
        Double saldoTotal = 0D;

        for (Movimento movimento : movimentos) {
            listaDeMovimentos +=
                    movimento.getDecricao()
                            + " = "
                            + movimento.getSinal()
                            + movimento.getValor()
                            + "\n";

            saldoTotal += converteParaValorFinal(movimento.getValor(), movimento.getTipo());
        }

        listaDeMovimentos += "\nSaldo atual = " + saldoTotal;

        return listaDeMovimentos;
    }

    private Double converteParaValorFinal(Double valor, String tipo) {
        if (tipo == "C") {
            return valor;
        } else/*D*/ {
            return valor * -1;
        }
    }
}
