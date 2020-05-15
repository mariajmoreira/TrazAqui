package trazAqui;

import java.util.List;
import  java.util.ArrayList;

public class LogLoja extends Loja {
    private String username;
    private String password;
    private CatalogoProdutos cp;

    public LogLoja(){
        super();
        this.username = new String();
        this.password = new String();
        this.cp = new CatalogoProdutos();
    }

   /* public LogLoja(Loja l, List<Produto> p){
        super(l.getCodLoja(),l.getNome(),l.getGps());
        this.username = "";
        this.password= "";
        setProdutos(p);
    }

    */

    public LogLoja(String cod,String nome,Localizacao pos, String user, String pass,CatalogoProdutos l){
        super(cod,nome,pos);
        this.username = user;
        this.password=pass;
        setCatalogoProdutos(l);
    }

    public LogLoja(LogLoja logL){
        super(logL.getCodLoja(),logL.getNome(),logL.getGps());
        this.username = getUsername();
        this.password=getPassword();
        setCatalogoProdutos(logL.getCatalogoProdutos());
    }

    public CatalogoProdutos getCatalogoProdutos(){
        return new CatalogoProdutos(cp);
    }

    public void setCatalogoProdutos(CatalogoProdutos c){
        this.cp=new CatalogoProdutos(c);

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

  /*
    public void addProduto(Produto prod){
        List<Produto> ret = this.getProdutos();
        ret.add(prod.clone());
        setProdutos(ret);

    }

   */

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Username:").append(this.username).append("\n");
        sb.append("Password").append(this.password).append("\n");
        return sb.toString();
    }



    public LogLoja clone(){
        return new LogLoja(this);
    }
/*
    public int removeProduto(String mat){
        List<Produto> ret = this.getProdutos(); Produto x = new Produto(); int res = 0;
        //Iterator it = ret.iterator();
        /*while(it.hasNext()){
            Veiculo v = (Veiculo) it.next();
            if(v.getMatricula().equals(mat))
                it.remove();

        }
        for(Produto k : ret){
            if(k.getDescricao().equals(mat)){
                x = k;
                res = 1;
            }
        }
        ret.remove(x);
        setProdutos(ret);
        return res;
    }

 */


    public boolean equals(Object o){
        if(this ==o) return true;
        if((o == null)|| (o.getClass() != this.getClass())) return false;

        LogLoja owner = (LogLoja) o;

        return (super.equals(owner)
                && owner.getUsername().equals(this.getUsername())
                && owner.getPassword().equals(this.getPassword()));
    }

}
