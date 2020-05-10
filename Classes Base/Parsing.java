 

import java.util.List;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class Parsing {

    public void parse(){
        List<String> linhas = lerFicheiro("LogsTeste.csv"); //alterar nome do ficheiro
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Utilizador":
                    Utilizador u = parseUtilizador(linhaPartida[1]); // criar um Utilizador
                    System.out.println(u.toString()); //enviar para o ecrÃ¡n apenas para teste
                    break;
                case "Loja":
                    Loja l = parseLoja(linhaPartida[1]);
                    System.out.println(l.toString());
                    break;
                case "Transportadora":
                    Transportadora t = parseTransportadora(linhaPartida[1]); // criar um Utilizador
                    System.out.println(t.toString()); //enviar para o ecrÃ¡n apenas para teste
                    break;
                case "Voluntario":
                    Voluntario v = parseVoluntario(linhaPartida[1]); // criar um Utilizador
                    System.out.println(v.toString()); //enviar para o ecrÃ¡n apenas para teste
                    break;
                case "Encomenda":
                    Encomenda e = parseEncomenda(linhaPartida[1]); // criar um Utilizador
                    System.out.println(e.toString()); //enviar para o ecrÃ¡n apenas para teste
                    break;
                default:
                    System.out.println("Linha invÃ¡lida.");
                    break;
            }

        }
        System.out.println("done!");
    }

    public Utilizador parseUtilizador(String input){
        String[] campos = input.split(",");
        String codUtilizador = campos[0];
        String nome = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        //String username = campos[4];
        //String password = campos[5];
        return new Utilizador(codUtilizador,nome,gpsx,gpsy);
    }

    public Loja parseLoja(String input){
        String[] campos = input.split(",");
        String codLoja = campos[0];
        String nome = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        //String username = campos[4];
        //String password = campos[5];
        return new Loja(codLoja,nome,gpsx,gpsy);
    }

    public Transportadora parseTransportadora(String input){
        String[] campos = input.split(",");
        String codEmpresa = campos[0];
        String nome = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        //String username = campos[4];
        //String password = campos[5];
        double raio = Double.parseDouble(campos[5]);
        double precoporkm = Double.parseDouble(campos[6]);
        String nif = campos[4];
        return new Transportadora(codEmpresa,nome,gpsx,gpsy,nif,raio,precoporkm);
    }

    public Voluntario parseVoluntario(String input){
        String[] campos = input.split(",");
        String codVoluntario = campos[0];
        String nome = campos[1];
        //String username = campos[2];
        //String password = campos[3];
        double gpsx = Double.parseDouble(campos[4]);
        double gpsy = Double.parseDouble(campos[5]);
        double raio = Double.parseDouble(campos[6]);
        //boolean disponibilidade = Boolean.parseBoolean(campos[7]);
        return new Voluntario(codVoluntario,nome,gpsx,gpsy,raio);
    }

    public Encomenda parseEncomenda(String input){
        String[] campos = input.split(",");
        String codEncomenda = campos[0];
        String codUtilizador = campos[1];
        String codLoja = campos[2];
        double peso = Double.parseDouble(campos[3);
        ArrayList<LinhaEncomenda> linhas = new ArrayList<>;
        for(linhas){
            LinhaEncomenda linha = parseLinhaEncomenda(campos[4]);
            linhas.add(linha);
        }
        return new Encomenda(codEncomenda,codUtilizador,codLoja,peso,linhas);
    }

    public LinhaEncomenda parseLinhaEncomenda(String input){
        String[] campos = input.split(",");
        String codProd = campos[0];
        String descricao = campos[1];
        int quantidade = Integer.parseInt(campos[2]);
        double preco = Double.parseDouble(campos[3);
        return new LinhaEncomenda(codProd,descricao,preco,quantidade);
    }

    public List<String> lerFicheiro(String nomeFich) {
        List<String> lines = new ArrayList<>();
        try{lines = Files.readAllLines(Paths.get("LogsTeste.csv"), StandardCharsets.UTF_8);}
        catch(IOException exc) { System.out.println(exc.getMessage()); }
        return lines;
    }
}
