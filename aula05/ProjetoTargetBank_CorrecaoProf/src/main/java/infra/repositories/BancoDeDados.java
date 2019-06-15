package infra.repositories;

import dominio.model.Correntista;

import java.util.ArrayList;

public class BancoDeDados {
    private static ArrayList<Correntista> correntistas;

    public static ArrayList<Correntista> getCorrentistas(){
        if(correntistas == null){
            correntistas = new ArrayList<>();
        }

        return correntistas;
    }
}
