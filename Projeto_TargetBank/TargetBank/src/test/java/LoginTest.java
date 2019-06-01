import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest {
    @Before
    public  void configurarTestes(){
        CargaInicial.popularCorrentistas();
    }
    @Test
    public void deve_realizar_login(){
        //Cenario
        int numeroContaCorrentista = 123456;
        int agenciaCorrentista = 456;
        int senhaCorrentista = 987654;
        Correntista correntista = new Correntista(new Conta(numeroContaCorrentista,agenciaCorrentista),senhaCorrentista);
        Conta conta = correntista.getConta();
        long numeroConta = conta.getNumero();
        int agencia = conta.getAgencia();
        int senha = correntista.getSenha();
        Login login = new Login();


        //Ação

        boolean loginSucesso = login.realizarLogin(agencia,numeroConta,senha);

        //Validação

        Assert.assertTrue(loginSucesso);

    }
}
