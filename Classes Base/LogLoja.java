package trazAqui;

import java.util.List;
import  java.util.ArrayList;

public class LogLoja extends Loja {
    private String username;
    private String password;
    private List<Produto> produtos;

    public LogLoja(){
        super();
        this.username = new String();
        this.password = new String();
        this.produtos = new ArrayList<>();
    }

    public LogLoja(String cod,String nome,double gpsx, double gpsy, String user, String pass,List<Produto> produtos){
        super(cod,nome,gpsx,gpsy);
        this.username = user;
        this.password=pass;
        setProdutos(produtos);
    }

    public LogLoja(LogLoja logL){
        super(logL.getCodLoja(),logL.getNome(),logL.getCoordenadaX(), logL.getCoordenadaY());
        this.username = getUsername();
        this.password=getPassword();
        this.produtos = logL.getProdutos();
    }

    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Produto> getProdutos(){
        List<Produto> res = new ArrayList<>();
        for(Produto v : this.produtos){
            res.add(v.clone());
        }
        return res;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public void setProdutos(List<Produto> lista){
        this.produtos = new ArrayList<>();
        for(Produto v : lista){
            this.produtos.add(v.clone());
        }
    }

    public void addProduto(Produto prod){
        List<Produto> ret = this.getProdutos();
        ret.add(prod.clone());
        setProdutos(ret);

    }

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

    public int removeProduto(String mat){
        List<Produto> ret = this.getProdutos(); Produto x = new Produto(); int res = 0;
        //Iterator it = ret.iterator();
        /*while(it.hasNext()){
            Veiculo v = (Veiculo) it.next();
            if(v.getMatricula().equals(mat))
                it.remove();

        }*/
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

    public boolean equals(Object o){
        if(this ==o) return true;
        if((o == null)|| (o.getClass() != this.getClass())) return false;

        LogLoja owner = (LogLoja) o;

        return (super.equals(owner)
                && owner.getUsername().equals(this.getUsername())
                && owner.getPassword().equals(this.getPassword()));
    }

}
