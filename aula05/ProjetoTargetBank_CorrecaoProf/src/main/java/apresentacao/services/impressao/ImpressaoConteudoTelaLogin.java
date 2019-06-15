package apresentacao.services.impressao;

public class ImpressaoConteudoTelaLogin implements ImpressaoConteudoInterface {
    @Override
    public String imprimir() {
        return "\n" +
                "Agencia: \n" +
                "dominio.model.Conta:\n" +
                "Senha:\n" +
                "\n";
    }
}
