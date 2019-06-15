public class Login {
    public boolean realizarLogin(int agencia, long numeroConta, int senha) {

        Correntista correntista = BancoDeDados.getCorrentistas().get(0);
            if(agencia == correntista.getConta().getAgencia() && numeroConta == correntista.getConta().getNumero()
            && senha == correntista.getSenha()){
                return true;
            }else{
                return false;
            }
    }
}
