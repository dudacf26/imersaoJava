package apresentacao.services.enums;

public enum OpcaoMenu {
    Extrato,
    Saldo,
    Deposito,
    Saque,
    Pagamentos;

    public static OpcaoMenu fromInteger(int value){
        switch (value){
            case 1:
                return Extrato;
            case 2:
                return Saldo;
            case 3:
                return Deposito;
            case 4:
                return Saque;
            case 5:
                return Pagamentos;

        }
        return null;
    }
}
