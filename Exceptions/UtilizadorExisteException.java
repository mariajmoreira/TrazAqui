package trazAqui.Exceptions;

import trazAqui.Utilizador;

public class UtilizadorExisteException extends Exception {
    /**
     * Construtor vazio
     */
    public UtilizadorExisteException()
    {
        super();
    }

    /**
     * Construtor parametrizado
     * @param msg A mensagem a exibir
     */
    public UtilizadorExisteException(String msg)
    {
        super(msg);
    }

}
