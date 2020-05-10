package trazAqui;

import jdk.jshell.execution.Util;

public class LogUtilizador extends Utilizador {
    private String username;
    private String password;

    public LogUtilizador(){
        super();
        this.username = new String();
        this.password = new String();
    }

    public LogUtilizador(String cod,String nome,double gpsx, double gpsy, String user, String pass){
        super(cod,nome,gpsx,gpsy);
        this.username = user;
        this.password=pass;
    }

    public LogUtilizador(Utilizador u, String user, String pass){
        super(u.getCodUtilizador(),u.getNome(),u.getCoordenadaX(),u.getCoordenadaY());
        this.username = user;
        this.password=pass;
    }

    public LogUtilizador(LogUtilizador logU){
        super(logU.getCodUtilizador(),logU.getNome(),logU.getCoordenadaX(), logU.getCoordenadaY());
        this.username = getUsername();
        this.password=getPassword();
    }

    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Username:").append(this.username).append("\n");
        sb.append("Password").append(this.password).append("\n");
        return sb.toString();
    }

    public LogUtilizador clone(){
        return new LogUtilizador(this);
    }

    public boolean equals(Object o){
        if(this ==o) return true;
        if((o == null)|| (o.getClass() != this.getClass())) return false;

        LogUtilizador owner = (LogUtilizador) o;

        return (super.equals(owner)
                && owner.getUsername().equals(this.getUsername())
                && owner.getPassword().equals(this.getPassword()));
    }

}
