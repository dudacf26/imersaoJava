import java.util.ArrayList;

public class BancoDeDados {
    private static ArrayList<Correntista> correntistas;

    public static  ArrayList<Correntista> getCorrentistas(){
        if(correntistas == null){
            correntistas = new ArrayList<Correntista>();
        }
        return  correntistas;
    }
}
