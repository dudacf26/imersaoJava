import apresentacao.services.enums.OpcaoMenu;
import apresentacao.services.impressao.Impressao;
import apresentacao.services.impressao.ImpressaoConteudoInterface;
import apresentacao.services.impressao.ImpressaoConteudoTelaExtato;
import apresentacao.services.impressao.ImpressaoConteudoTelaLogin;
import apresentacao.services.impressao.ImpressaoConteudoTelaOpcao;
import dominio.model.Correntista;
import dominio.services.Login;
import infra.services.CargaInicial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CargaInicial.populaCorrentistas();

        ImpressaoConteudoTelaLogin telaLogin = new ImpressaoConteudoTelaLogin();
        Impressao impressao = new Impressao();
        String loginScreen = impressao.imprimirTela(telaLogin);
        System.out.println(loginScreen);

        Scanner scanner = new Scanner(System.in); // obter os dados

        int agencia = scanner.nextInt();
        long conta = scanner.nextLong();
        int senha = scanner.nextInt();

        Login login = new Login();

        Correntista correntistaComSucesso = login.realizarLogin(agencia, conta, senha);

        if (correntistaComSucesso != null) {
            ImpressaoConteudoInterface telaOpcao = new ImpressaoConteudoTelaOpcao();
            String telaOpcaoScreen = impressao.imprimirTela(telaOpcao);
            System.out.println(telaOpcaoScreen);

            OpcaoMenu opcaoSelecionada = OpcaoMenu.fromInteger(scanner.nextInt());

            switch (opcaoSelecionada) {
                case Extrato:
                    System.out.println(
                            impressao.imprimirTela(
                                    correntistaComSucesso.getNome(),
                                    correntistaComSucesso.getConta().getAgencia(),
                                    correntistaComSucesso.getConta().getNumero(),
                                    new ImpressaoConteudoTelaExtato(correntistaComSucesso.getConta().getMovimentos())
                            )
                    );
                    break;
                case Saldo:
                    //impressao.imprimirTela();
                    break;
                case Deposito:
                    break;
                case Saque:
                    break;
                case Pagamentos:
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } else {
            System.out.println("Usuario e/ou senha incorretos");
        }
    }
}
