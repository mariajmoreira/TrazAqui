package trazAqui;

import trazAqui.Exceptions.*;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InvalidClassException;

/**
 * Main
 * Classe que inicia todo o programa
 * Invoca o carregamento do ficheiro gravado por OIS ("DataBase1")
 * Caso não consiga encontrar esse ficheiro ou ocorra algum erro de carregamento,
 * carrega o ficheiro fornecido pelo docente
 *
 * @author Pedro Oliveira, Luis Bigas, Bruno Alves
 *
 */
public class Main
{
    /**
     * Método que inicia o programa
     */
    public static void main(String[] args) throws UtilizadorExisteException, CodigoJaEstaEmUsoException, LojaExisteException, TransportadoraExisteException, VoluntarioExisteException, EncomendaExisteException {

        BaseDados database = new BaseDados();
        Armazena armazena = new Armazena();
        Parsing p = new Parsing(armazena);
        Menu main_menu = new Menu(database,armazena);
        //System.out.println(armazena.getEncomenda("e6813").getLinhas().toString());
        //System.out.println(database.getLo("e6813").getLinhas().toString());
    }


}
