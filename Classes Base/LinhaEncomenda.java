 

import java.util.ArrayList;

public class LinhaEncomenda extends Produto {
    private int quantidade;

    public LinhaEncomenda() {
        super();
        this.quantidade = 0;
    }

    public LinhaEncomenda(String cod, String descricao, double preco, int quantidade) {
        super(cod,descricao,preco)
        this.quantidade = quantidade;
    }

    public LinhaEncomenda(LinhaEncomenda linha) {
        super(linha.getCodProd(),linha.getDescricao(),linha.getQuantidade());
        this.quantidade = linha.getQuantidade();
    }

    public String getCodProd() {
        return this.codProd;
    }

    public void setCodProd(String cod) {
        this.codProd= cod;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LinhaEncomenda clone() {
        return new LinhaEncomenda(this);
    }

    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj==null || obj.getClass() != this.getClass()) return false;
        LinhaEncomenda le = (LinhaEncomenda) obj;
        return le.getCodProd().equals(this.codProd) &&
                le.getDescricao().equals(this.descricao) &&
                le.getPreco() == this.preco;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Encomendas:\n").append("Codigo Produto:").append(this.codProd).append("\n").append("Descriçao:")
                .append(this.descricao).append("\n").append("Preco:").append(this.preco)
                .append("\n").append("Quantidade:").append(this.quantidade).append("\n");
        return sb.toString();
    }
}
