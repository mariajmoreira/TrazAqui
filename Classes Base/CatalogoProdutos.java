package trazAqui;

import java.util.ArrayList;

public class CatalogoProdutos {
    private String codLoja;
    private ArrayList<Produto> produtos;

    public CatalogoProdutos(){
        this.codLoja="";
        this.produtos= new ArrayList<Produto>();
    }

    public CatalogoProdutos(String cod,ArrayList<Produto> p){
        this.codLoja=cod;
        this.produtos=new ArrayList<>();
        for(Produto s : p){
            this.produtos.add(s);
        }
    }

    public CatalogoProdutos(CatalogoProdutos e){
        this.codLoja=e.getCodLoja();
        setProdutos(e.getProdutos());
    }

    public ArrayList<Produto> getProdutos(){
        ArrayList<Produto> aux = new ArrayList<>();
        for(Produto s : this.produtos){
            aux.add(s);
        }
        return aux;
    }

    public void setProdutos(ArrayList<Produto> enc){
        this.produtos= new ArrayList<>();
        for(Produto s : enc){
            this.produtos.add(s);
        }
    }

    public String getCodLoja(){
        return this.codLoja;
    }

    public void setCodLoja(String cod) {
        this.codLoja = cod;
    }

    public CatalogoProdutos clone() {
        return new CatalogoProdutos(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Produtos:").append(this.produtos).append("\n");
        return sb.toString();
    }

}
