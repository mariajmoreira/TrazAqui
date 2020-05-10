package trazaqui;

import java.util.ArrayList;
import java.util.List;

public class LogLoja extends Loja{
    private String username;
    private String password;
    private List<Produto> produtos;

    //getters
    public String getUsername(){return username;}

    public String getPassword(){return password;}

    public ArrayList<Produto> getProdutos(){ return new ArrayList<>(this.produtos); }

    //setters
    public void setUsername(String user){this.username=user;}

    public void setPassword(String pass){this.password=pass;}

    public void setProdutos(ArrayList<Produto> prod){this.produtos=new ArrayList<>(prod);}

    //construtor vazio
    public LogLoja(){
        super();
        this.username="";
        this.password="";
        this.produtos=new ArrayList<>();
    }

    //construtores parametrizados
    public LogLoja(String cod,String nome, Localizacao pos, String user, String pass,ArrayList<Produto> prod){
        super(cod,nome,pos);
        this.username=user;
        this.password=pass;
        setProdutos(prod);
    }

    public LogLoja(Loja l, String user, String pass,ArrayList<Produto> prod){
        super(l.getCodLoja(),l.getNome(),l.getGps());
        this.username=user;
        this.password=pass;
        setProdutos(prod);
    }

    //construtor por cópia
    public LogLoja(LogLoja l){
        super(l.getCodLoja(),l.getNome(),l.getGps());
        this.username=l.getUsername();
        this.password=l.getPassword();
        setProdutos(l.getProdutos());
    }

    //metodo String
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append(super.toString());
        sb.append("Username:").append(this.username).append("\n")
                .append("Password:").append(this.password).append("\n")
                .append("Produtos:").append(this.produtos).append("\n");

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
                && loj.getPassword().equals(this.getPassword())
                && loj.getProdutos().equals(this.getProdutos());
    }

}
