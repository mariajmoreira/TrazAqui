package trazAqui;

public class Loja {
    private String codLoja;
    //private String username;
    //private String password;
    private String nome;
    private double gpsX;
    private double gpsY;

    //getters e setters
    public String getCodLoja(){
        return codLoja;
    }

   /* public String getUsername(){
        return username;
    }

    */

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

    /*public void setUsername(String user) {
        this.username=user;
    }

     */

    public void setNome(String nome) {
        this.nome = nome;
    }

   /* public void setPassword(String password) {
        this.password = password;
    }

    */

    public void setCodLoja(String user) {
        this.codLoja=user;
    }


    public void setCoordenadaX(double x) {
        this.gpsX = x;
    }

    public void setCoordenadaY(double y) {
        this.gpsY = y;
    }


    //Construtor por omissão
    public Loja(){
       // this.username="";
        //this.password="";
        this.codLoja="";
        this.nome="";
        this.gpsX=0;
        this.gpsY=0;
    }

    //Construtor parametrizado
    public  Loja(String cod,String n,double x, double y){
       // this.username=e;
        //this.password=p;
        this.codLoja=cod;
        this.nome=n;
        this.gpsX=x;
        this.gpsY=y;
    }

    //Construtor de copia
    public Loja(Utilizador u){
       // this.username=getUsername();
        //this.password=getPassword();
        this.codLoja=getCodLoja();
        this.nome=getNome();
        this.gpsX=getCoordenadaX();
        this.gpsY=getCoordenadaY();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Loja:\n").append("Nome:").append(this.nome).append("\n")
                .append("\n").append("Codigo Loja:").append(this.codLoja)
                .append("\n").append("Coordenadas:").append(this.gpsX).append(this.gpsY).append("\n");
        return sb.toString();
    }
}
