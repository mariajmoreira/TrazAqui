package trazAqui.Exceptions;

import trazAqui.Transportadora;

public class TransportadoraExisteException extends Exception{
    /**
     * Construtor vazio
     */
    public TransportadoraExisteException()
    {
        super();
    }

    /**
     * Construtor parametrizado
     * @param msg A mensagem a exibir
     */
    public TransportadoraExisteException(String msg)
    {
        super(msg);
    }
}
