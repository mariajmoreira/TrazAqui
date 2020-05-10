package trazAqui;

public class Utilizador {
    private String codUtilizador;
    //private String username;
    //private String password;
    private String nome;
    private double gpsX;
    private double gpsY;

    //getters e setters

   public String getCodUtilizador(){
        return codUtilizador;
    }

    public String getNome(){
        return nome;
    }

   /* public String getPassword(){
        return password;
    }
    */

    public double getCoordenadaX() {
        return gpsX;
    }

    public double getCoordenadaY() {
        return gpsY;
    }

   public void setCodUtilizador(String user) {
        this.codUtilizador=user;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   /* public void setPassword(String password) {
        this.password = password;
    }

    */

    public void setCoordenadaX(double x) {
        this.gpsX = x;
    }

    public void setCoordenadaY(double y) {
        this.gpsY = y;
    }


    //Construtor por omissão
    public Utilizador(){
        //this.username="";
        //this.password="";
        this.codUtilizador="";
        this.nome="";
        this.gpsX=0;
        this.gpsY=0;
    }

    //Construtor parametrizado
    public  Utilizador(String cod,String n,double x, double y){
       // this.username=e;
        //this.password=p;
        this.codUtilizador=cod;
        this.nome=n;
        this.gpsX=x;
        this.gpsY=y;
    }

    //Construtor de copia
    public Utilizador(Utilizador u){
        //this.username=getUsername();
        //this.password=getPassword();
        this.codUtilizador=getCodUtilizador();
        this.nome=getNome();
        this.gpsX=getCoordenadaX();
        this.gpsY=getCoordenadaY();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Utilizador:\n").append("Nome:").append(this.nome).append("\n")
                .append("\n").append("Codigo Utilizador:").append(this.codUtilizador)
                .append("\n").append("Coordenadas:").append(this.gpsX).append(this.gpsY).append("\n");
        return sb.toString();
    }
}
