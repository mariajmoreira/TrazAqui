package trazaqui;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Historico extends Encomenda{
    private String cod;
    private String nome;
    private LocalDateTime date;

    //getters
    public String getCod(){return this.cod;}

    public String getNome(){return this.nome;}

    public LocalDateTime getDate(){return this.date;}

    //setters
    public void setCod(String cod){this.cod=cod;}

    public void setNome(String nome){this.nome=nome;}

    //construtor vazio
    public Historico(){
        super();
        this.cod="";
        this.nome="";
        this.date=LocalDateTime.now();
    }

    //construtor parametrizado
    public Historico(String codEncomenda, String codUtilizador, String codLoja, double peso, ArrayList<LinhaEncomenda> l, String cod, String nome){
        super(codEncomenda,codUtilizador,codLoja,peso,l);
        this.cod=cod;
        this.nome=nome;
        this.date=LocalDateTime.now();
    }

    public Historico(Encomenda e, String cod,String nome){
        super(e.getcodEncomenda(),e.getcodUtilizador(),e.getcodLoja(),e.getPeso(),e.getLinhas());
        this.cod=cod;
        this.nome=nome;
        this.date=LocalDateTime.now();
    }

    //contrutor por cópia
    public Historico(Historico h){
        super(h.getcodEncomenda(),h.getcodUtilizador(),h.getcodLoja(),h.getPeso(),h.getLinhas());
        this.nome=h.getNome();
        this.cod=h.getCod();
        this.date=h.getDate();
    }

    //método toString
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(this.date).append("\n")
                .append("Entregue por:").append(this.nome).append("\n")
                .append("Código:").append(this.cod).append("\n");
        sb.append(super.toString());

        return sb.toString();
    }

    //método clone
    public Historico clone(){
        return new Historico(this);
    }

    //método equals
    public boolean equals(Object o){
        if(o==this) return true;
        if((o==null) || (o.getClass()!=this.getClass())) return false;

        Historico h= (Historico) o;

        return super.equals(o)
                && h.getCod().equals(this.getCod())
                && h.getNome().equals(this.getNome())
                && h.getDate().equals(this.getDate());
    }
}