package trazAqui;

public class LogVoluntario extends Voluntario {
    private String username;
    private String password;
    private boolean disponibilidade;

    public LogVoluntario(){
        super();
        this.username = new String();
        this.password = new String();
        this.disponibilidade = false;
    }

    public LogVoluntario(String cod,String nome,Localizacao pos, double raio,String user, String pass, Boolean d){
        super(cod,nome,pos,raio);
        this.username = user;
        this.password=pass;
        this.disponibilidade = d;
    }

    public LogVoluntario(LogVoluntario logV){
        super(logV.getCodVoluntario(),logV.getNome(),logV.getPosicao(),logV.getRaio());
        this.username = getUsername();
        this.password=getPassword();
        this.disponibilidade=getDisponibilidade();
    }

    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }


    public boolean getDisponibilidade(){
        return disponibilidade;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public void setDisponibilidade(Boolean d) {
        this.disponibilidade = d;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Username:").append(this.username).append("\n");
        sb.append("Password").append(this.password).append("\n");
        return sb.toString();
    }

    public LogVoluntario clone(){
        return new LogVoluntario(this);
    }


    public boolean equals(Object o){
        if(this ==o) return true;
        if((o == null)|| (o.getClass() != this.getClass())) return false;

        LogVoluntario owner = (LogVoluntario) o;

        return (super.equals(owner)
                && owner.getUsername().equals(this.getUsername())
                && owner.getPassword().equals(this.getPassword()));
    }
}
