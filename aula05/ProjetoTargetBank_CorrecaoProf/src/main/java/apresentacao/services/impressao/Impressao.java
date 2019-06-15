package apresentacao.services.impressao;

public class Impressao {

    public String imprimirTela(String nomeCorrentista
            , int agencia
            , long numeroConta
            , ImpressaoConteudoInterface imprimirConteudo) {
        String telaOpcao =
                this.imprimirCabecalho() +
                        this.imprimirDadosCliente(nomeCorrentista, agencia, numeroConta) +
                        "\n*************************************\n" +
                        imprimirConteudo.imprimir() +
                        "\n" +
                        this.imprimirRodape();

        return telaOpcao;
    }

    public String imprimirTela(ImpressaoConteudoInterface imprimirConteudo) {
        String telaOpcao =
                this.imprimirCabecalho()
                        + imprimirConteudo.imprimir()
                        + this.imprimirRodape();

        return telaOpcao;
    }

    public String imprimirCabecalho() {
        String cabecalho = "************ Target Bank ************\n";
        return cabecalho;
    }

    public String imprimirRodape() {
        return "*************************************";
    }

    public String imprimirDadosCliente(String nome, int agencia, long numero) {
        return "Nome: " + nome + " \n" +
                "Ag: " + agencia + "\n" +
                "Cc: " + numero;
    }
}
