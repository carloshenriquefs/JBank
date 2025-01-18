package tech.buildrun.jbank.exception;

public class WalletDataAlreadyExistsException extends JBankException {

    public WalletDataAlreadyExistsException(String message) {
        super(message);
    }
}
