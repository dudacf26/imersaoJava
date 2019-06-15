package dominio.services;

import dominio.model.Correntista;
import infra.repositories.BancoDeDados;

public class Login {

    public Correntista realizarLogin(int agencia
            , long numeroConta
            , int senha) {

        Correntista correntista = BancoDeDados.getCorrentistas()
                .stream()
                .filter(correntistaItem -> agencia == correntistaItem.getConta().getAgencia()
                        && numeroConta == correntistaItem.getConta().getNumero()
                        && senha == correntistaItem.getSenha())
                .findFirst()
                .get();

        if(correntista != null){
            return correntista;
        }else {
            return null;
        }
    }
}
