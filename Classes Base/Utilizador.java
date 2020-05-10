package trazaqui;

public class Utilizador {
    private String codUtilizador;
    private String nome;
    private Localizacao gps;

    //getters
    public String getCodUtilizador(){return codUtilizador;}

    public String getNome(){return nome;}

    public Localizacao getGps(){return new Localizacao(this.gps.getX(),this.gps.getY());}

    //setters
    public void setCodUtilizador(String c){this.codUtilizador=c;}

    public void setNome(String n){this.nome=n;}

    public void setGps(Localizacao pos){this.gps = new Localizacao(pos);}

    //construtor por omissão

    public Utilizador(){
        this.codUtilizador="";
        this.nome="";
        this.gps=new Localizacao();
    }

    //construtor parametrizado

    public Utilizador(String cod, String nome, Localizacao pos){
        this.codUtilizador=cod;
        this.nome=nome;
        setGps(pos);
    }

    //construtor por cópia

    public Utilizador(Utilizador u){
        this.codUtilizador=getCodUtilizador();
        this.nome=getNome();
        setGps(u.getGps());
    }

    //metodo toString
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("Utilizador:\n").append("Nome:").append(this.nome).append("\n")
                .append("Código Utilizador:").append(this.codUtilizador).append("\n")
                .append("Coordenadas:").append("(").append(this.gps).append("\n");

        return sb.toString();
    }
}
