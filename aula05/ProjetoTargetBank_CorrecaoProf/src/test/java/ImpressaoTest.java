import apresentacao.services.impressao.Impressao;
import apresentacao.services.impressao.ImpressaoConteudoInterface;
import apresentacao.services.impressao.ImpressaoConteudoTelaExtato;
import apresentacao.services.impressao.ImpressaoConteudoTelaLogin;
import apresentacao.services.impressao.ImpressaoConteudoTelaOpcao;
import dominio.model.Conta;
import dominio.model.Correntista;
import dominio.model.Movimento;
import org.junit.Before;
import org.junit.Test;
import stub.ImpressaoStub;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ImpressaoTest {

    private Impressao impressao;
    private Correntista correntista;

    @Before
    public void setUp(){
        impressao = new Impressao();
        List<Movimento> movimentos = asList(
                new Movimento("Paqueta", "D", 50.00D),
                new Movimento("Deposito", "C", 25.00D),
                new Movimento("Saque", "D", 120.00D)
        );
        Conta conta = new Conta(1647, 2603);
        conta.setMovimentos(movimentos);
        correntista = new Correntista(conta, 123456, "Zezinho");
    }

    @Test
    public void deve_imprimir_tela_opcoes(){

        // Cenario
        impressao = this.impressao;
        String nomeCorrentista = correntista.getNome();
        int agencia = correntista.getConta().getAgencia();
        long numeroConta = correntista.getConta().getNumero();
        ImpressaoConteudoTelaOpcao impressaoConteudo = new ImpressaoConteudoTelaOpcao();

        // Acao
        String telaOpcao = impressao.imprimirTela(nomeCorrentista,agencia,numeroConta, impressaoConteudo);

        // Validação
        assertEquals(telaOpcao, ImpressaoStub.telaOpcao());
    }

    @Test
    public void deve_imprimir_cabecalho(){
        // Cenario
        impressao = this.impressao;

        // Acao
        String cabecalho = impressao.imprimirCabecalho();

        // Validacao
        assertEquals(cabecalho, ImpressaoStub.cabecalho());
    }

    @Test
    public void deve_imprimir_rodape(){

        //Cenario
        impressao = this.impressao;

        //Acao
        String rodape = impressao.imprimirRodape();

        //Validacao
        assertEquals(rodape, ImpressaoStub.rodape());
    }

    @Test
    public void deve_imprimir_dados_cliente(){
        // Cenario
        impressao = this.impressao;

        // Acao
        String dadosCliente = impressao.imprimirDadosCliente(
                correntista.getNome(),
                correntista.getConta().getAgencia(),
                correntista.getConta().getNumero()
        );

        // Validacao
        assertEquals(dadosCliente, ImpressaoStub.dadosCliente());
    }

    @Test
    public void deve_imprimir_tela_login(){

        // Cenario
        impressao = this.impressao;
       ImpressaoConteudoTelaLogin impressaoLogin = new ImpressaoConteudoTelaLogin();

        // Acao
        String telaLogin = impressao.imprimirTela(
                impressaoLogin
        );

        // Validacao
        assertEquals(telaLogin, ImpressaoStub.telaLogin());

    }

    @Test
    public void deve_imprimir_tela_extrato(){

        //Cenario
        impressao = this.impressao;
        List<Movimento> movimentos = correntista.getConta().getMovimentos();
        ImpressaoConteudoInterface impressaoConteudoTelaExtato = new ImpressaoConteudoTelaExtato(
                correntista.getConta().getMovimentos()
        );

        // Acao
        String telaExtrato = impressao.imprimirTela(
                correntista.getNome(),
                correntista.getConta().getAgencia(),
                correntista.getConta().getNumero(),
                impressaoConteudoTelaExtato
        );

        // Validacao
        assertEquals(telaExtrato, ImpressaoStub.telaExtrato());
    }

}
