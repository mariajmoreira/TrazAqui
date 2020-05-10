package trazAqui;

public class LogTransportadora extends Transportadora {
    private String username;
    private String password;

    public LogTransportadora(){
        super();
        this.username = new String();
        this.password = new String();
    }

    public LogTransportadora(String cod,String nome,double gpsx, double gpsy, String nif,double raio, double preco,String user, String pass){
        super(cod,nome,gpsx,gpsy,nif,raio,preco);
        this.username = user;
        this.password=pass;
    }

    public LogTransportadora(LogTransportadora logT){
        super(logT.getCodEmpresa(),logT.getNome(),logT.getCoordenadaX(), logT.getCoordenadaY(),logT.getNIF(),logT.getRaio(),logT.getPrecoporkm());
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

    public LogTransportadora clone(){
        return new LogTransportadora(this);
    }

    public boolean equals(Object o){
        if(this ==o) return true;
        if((o == null)|| (o.getClass() != this.getClass())) return false;

        LogTransportadora owner = (LogTransportadora) o;

        return (super.equals(owner)
                && owner.getUsername().equals(this.getUsername())
                && owner.getPassword().equals(this.getPassword()));
    }
}
