package apresentacao.services.impressao;

public class ImpressaoConteudoTelaOpcao implements ImpressaoConteudoInterface{
    @Override
    public String imprimir() {
        return "Opcoes\n" +
                "\n" +
                "1 - Extrato\n" +
                "2 - Saldo\n" +
                "3 - Deposito\n" +
                "4 - Saque\n" +
                "5 - Pagamentos\n" +
                "\n";
    }
}
