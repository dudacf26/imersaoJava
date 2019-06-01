public class CargaInicial {
    public static  void popularCorrentistas(){
        Conta conta = new Conta (123456,456);
        Correntista correntista = new Correntista(conta,987654);
        BancoDeDados.getCorrentistas().add(correntista);
    }
}
