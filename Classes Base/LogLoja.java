package trazaqui;

public class LogLoja extends Loja{
    private String username;
    private String password;

    //getters
    public String getUsername(){return username;}

    public String getPassword(){return password;}

    //setters
    public void setUsername(String user){this.username=user;}

    public void setPassword(String pass){this.password=pass;}

    //construtor vazio
    public LogLoja(){
        super();
        this.username="";
        this.password="";
    }

    //construtores parametrizados
    public LogLoja(String cod,String nome, Localizacao pos, String user, String pass){
        super(cod,nome,pos);
        this.username=user;
        this.password=pass;
    }

    public LogLoja(Loja l, String user, String pass){
        super(l.getCodLoja(),l.getNome(),l.getGps());
        this.username=user;
        this.password=pass;
    }

    //construtor por cópia
    public LogLoja(LogLoja l){
        super(l.getCodLoja(),l.getNome(),l.getGps());
        this.username=l.getUsername();
        this.password=l.getPassword();
    }

    //metodo String
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append(super.toString());
        sb.append("Username:").append(this.username).append("\n")
                .append("Password:").append(this.password).append("\n");

        return sb.toString();
    }

    //metodo clone
    public LogLoja clone(){ return new LogLoja(this);}

    //metodo equals
    public boolean equals(Object o){
        if (o==this) return true;
        if ((o==null) || (o.getClass()!=this.getClass())) return false;

        LogLoja loj= (LogLoja) o;

        return super.equals(loj)
                && loj.getUsername().equals(this.getUsername())
                && loj.getPassword().equals(this.getPassword());
    }

}
