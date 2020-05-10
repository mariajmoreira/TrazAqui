package trazAqui;

public class Transportadora {
    private String codEmpresa;
    //private String username;
    //private String password;
    private String nome;
    private double gpsX;
    private double gpsY;
    private String nif;
    private double raio;
    private double precoporkm;

    //getters e setters

    public String getCodEmpresa(){
        return codEmpresa;
    }

   /* public String getUsername(){
        return username;
    }
    */

    public String getNome(){
        return nome;
    }

  /*  public String getPassword(){
        return password;
    }

   */

    public double getCoordenadaX() {
        return gpsX;
    }

    public double getCoordenadaY() {
        return gpsY;
    }

    public String getNIF(){
        return nif;
    }

    public double getRaio() {
        return raio;
    }

    public double getPrecoporkm() {
        return precoporkm;
    }

    public void setCodEmpresa(String cod) {
        this.codEmpresa=cod;
    }

   /* public void setUsername(String user) {
        this.username=user;
    }

    */

    public void setNome(String nome) {
        this.nome = nome;
    }

  /*  public void setPassword(String password) {
        this.password = password;
    }

   */

    public void setCoordenadaX(double x) {
        this.gpsX = x;
    }

    public void setCoordenadaY(double y) {
        this.gpsY = y;
    }

    public void setNIF(String n) {
        this.nif = n;
    }

    public void setRaio(double r) {
        this.raio = r;
    }

    public void setPrecoporkm(double p) {
        this.precoporkm= p;
    }


    //Construtor por omissão
    public Transportadora(){
        this.codEmpresa ="";
        //this.username="";
        //this.password="";
        this.nome="";
        this.gpsX=0.0;
        this.gpsY=0.0;
        this.nif="";
        this.raio=0.0;
        this.precoporkm=0.0;
    }

    //Construtor parametrizado
    public  Transportadora(String c,String n,double x, double y,String nif, double r, double preco){
        //this.username=u;
        //this.password=p;
        this.codEmpresa =c;
        this.nome=n;
        this.gpsX=x;
        this.gpsY=y;
        this.nif=nif;
        this.raio=r;
        this.precoporkm=preco;
    }

    //Construtor de copia
    public Transportadora(Transportadora t){
        //this.username=getUsername();
        //this.password=getPassword();
        this.nome=getNome();
        this.gpsX=getCoordenadaX();
        this.gpsY=getCoordenadaY();
        this.nif=getNIF();
        this.raio=getRaio();
        this.precoporkm=getPrecoporkm();
        this.codEmpresa =getCodEmpresa();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Transportadora:\n").append("Nome:").append(this.nome).append("\n")
                .append("\n").append("Codigo Transportadora:").append(this.codEmpresa)
                .append("\n").append("Coordenadas:").append(this.gpsX).append(this.gpsY)
                .append("\n").append("Raio:").append(this.raio)
                .append("\n").append("NIF:").append(this.nif)
                .append("\n").append("Preço por km:").append(this.precoporkm);
        return sb.toString();
    }
}
