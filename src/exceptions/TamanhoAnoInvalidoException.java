package exceptions;

public class TamanhoAnoInvalidoException extends RuntimeException {
    String mensagem;
    public TamanhoAnoInvalidoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }
}
