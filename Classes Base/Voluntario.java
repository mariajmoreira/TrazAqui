package trazAqui;

public class Voluntario {
    private String codVoluntario;
    private String nome;
    private Localizacao posicao;
    private double gpsX;
    private double gpsY;
    private double raio;


    public String getCodVoluntario(){
        return codVoluntario;
    }

   /* public String getUsername(){
        return username;
    }

    */

    public String getNome(){
        return nome;
    }

    /*public String getPassword(){
        return password;
    }

     */

    /*public boolean getDisponibilidade(){
        return disponibilidade;
    }

     */

    public double getCoordenadaX() {
        return gpsX;
    }

    public double getCoordenadaY() {
        return gpsY;
    }

    public double getRaio() {
        return raio;
    }

    public void setCodVoluntario(String cod) {
        this.codVoluntario=cod;
    }

   /* public void setUsername(String user) {
        this.username=user;
    }

    */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /*public void setPassword(String password) {
        this.password = password;
    }

    public void setDisponibilidade(boolean d) {
        this.disponibilidade = d;
    }

     */

    public void setCoordenadaX(double x) {
        this.gpsX = x;
    }

    public void setCoordenadaY(double y) {
        this.gpsY = y;
    }

    public void setRaio(double r) {
        this.raio = r;
    }

    //Construtor por omissão
    public Voluntario(){
        this.codVoluntario = "";
        this.nome="";
        this.posicao = new Localizacao();
        this.raio = 0.0;
    }

    //Construtor parametrizado
    public  Voluntario(String cod,String n, Localizacao pos, double r){
        this.codVoluntario = cod;
        this.nome=n;
        this.setPosicao(pos);
        this.raio=r;
    }

    //Construtor de copia
    public Voluntario(Voluntario v){
        this.codVoluntario = v.getCodVoluntario();
        this.nome=v.getNome();
        this.setPosicao(v.getPosicao());
        this.raio = v.getRaio();
    }

    public void setPosicao(Localizacao b){
        this.posicao = new Localizacao(b);
    }

    /**
     * Método para obter a localização de um Veiculo
     * @return A localização do veículo
     */
    public Localizacao getPosicao(){
        return new Localizacao(this.posicao.getX(),this.posicao.getY());
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Voluntario:\n").append("Nome:").append(this.nome).append("\n")
                .append("\n").append("codVoluntario:").append(this.codVoluntario)
                .append("\n").append("Coordenadas:").append(this.gpsX).append(this.gpsY)
                .append("\n").append("Raio:").append(this.raio).append("\n");
        return sb.toString();
    }


    /*public boolean equals (Object o){
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass()) return false;
        Voluntario v = (Voluntario) o;
        return this.nome.equals(v.getNome()) && this.username.equals(v.getUsername());
    }*/
}
